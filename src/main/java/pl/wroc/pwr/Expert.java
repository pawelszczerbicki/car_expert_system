package pl.wroc.pwr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wroc.pwr.car.Car;
import pl.wroc.pwr.car.CarRank;
import pl.wroc.pwr.car.CarRankComparator;
import pl.wroc.pwr.car.Feature;

import java.util.*;

import static java.util.Map.Entry;

/**
 * Created by Pawel on 04.01.14.
 */
@Service
public class Expert {

    @Autowired
    private Knowledge knowledge;

    private Integer answeredQuestions;

    private static final String DELIMITER = "-";

    private Map<Car, List<String>> pluses = new HashMap<>();
    private Map<Car, List<String>> minuses = new HashMap<>();

    public List<CarRank> resolve(List<Answer> answers) {
        answeredQuestions = 0;
        Map<Car, Integer> rank = getRankMap();
        for (Answer a : answers)
            resolve(a, rank);

        return getCarRank(rank);
    }

    private List<CarRank> getCarRank(Map<Car, Integer> rank) {
        List<CarRank> carRanks = new ArrayList<>();
        for (Entry<Car, Integer> e : rank.entrySet()){
            CarRank carrrank = new CarRank(e.getKey(), ((double) e.getValue() * 100) / answeredQuestions);
            carrrank.setPluses(pluses.get(e.getKey()));
            carrrank.setMinuses(minuses.get(e.getKey()));
            carRanks.add(carrrank);
        }
        Collections.sort(carRanks, new CarRankComparator());
        return carRanks;
    }

    private void resolve(Answer a, Map<Car, Integer> rank) {
        answeredQuestions++;
        for (Entry<Car, Integer> e : rank.entrySet()) {
            e.setValue(e.getValue() + updateRank(a, e.getKey()));
        }
    }

    private Integer updateRank(Answer a, Car car) {
        Integer rank = 0;
        String answer = a.getAnswer();
        List<String> carPluses = new ArrayList<>();
        List<String> carMinuses = new ArrayList<>();
        String mop;
        double start;
        double stop;
        switch (a.getFeatureType()) {
            case ACCELERATION:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                mop = "Acceleration: " + car.getAcceleration();
                if (car.getAcceleration() >= start && car.getAcceleration() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case CAR_TYPE:
                mop = "Car type: " + answer;
                if (car.hasFeature(Feature.valueOf(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case DOORS:
                mop = "Doors: " + answer;
                if (car.getDoors().equals(Integer.parseInt(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case ENGINE_CAPACITY:
                mop = "Engine capacity: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getCapacity() >= start && car.getCapacity() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case FUEL_CONSUMPTION:
                mop = "Fuel consumption: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getFuelConsumption() >= start && car.getFuelConsumption() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case HORSE_POWER:
                mop = "Horse power: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getHorsePower() >= start && car.getHorsePower() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case MAX_SPEED:
                mop = "Max speed: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getMaxSpeed() >= start && car.getMaxSpeed() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case MOMENT:
                mop = "Moment: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getMoment() >= start && car.getMoment() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case PRICE:
                mop = "Price: " + answer;
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getPrice() >= start && car.getPrice() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case TRUNK:
                mop = "Trunk: " + answer;
                start = Integer.parseInt(answer.split(DELIMITER)[0]);
                stop = Integer.parseInt(answer.split(DELIMITER)[1]);
                if (car.getTrunk() >= start && car.getTrunk() <= stop) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case FUEL:
                mop = "Fuel: " + answer;
                if (car.hasFeature(Feature.valueOf(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case RAIL_TYPE:
                mop = "Rail type: " + answer;
                if (car.hasFeature(Feature.valueOf(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case TURBO:
                mop = "Turbo:  " + car.hasFeature(Feature.TURBO);
                if (car.hasFeature(Feature.TURBO) && answer.equalsIgnoreCase("Yes")) {
                    rank++;
                    carPluses.add(mop);
                }
                if (!car.hasFeature(Feature.TURBO) && answer.equalsIgnoreCase("No")) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case GEAR_BOX:
                mop = "Gear box: " + answer;
                if (car.hasFeature(Feature.valueOf(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
            case CAR_PURPOSE:
                mop = "Car purpose: " + answer;
                if (car.hasFeature(Feature.valueOf(answer))) {
                    rank++;
                    carPluses.add(mop);
                } else carMinuses.add(mop);
                break;
        }
        if(pluses.get(car) == null) pluses.put(car, new ArrayList<String>());
        if(minuses.get(car) == null) minuses.put(car, new ArrayList<String>());

        List<String> newPluses = new ArrayList<>();
        newPluses.addAll(pluses.get(car));
        newPluses.addAll(carPluses);
        pluses.put(car, newPluses);

        List<String> newMinuses = new ArrayList<>();
        newMinuses.addAll(minuses.get(car));
        newMinuses.addAll(carMinuses);
        minuses.put(car, newMinuses);
        return rank;
    }

    private Map<Car, Integer> getRankMap() {
        Map<Car, Integer> rank = new HashMap<>();
        for (Car c : knowledge.getCars()) {
            rank.put(c, 0);
        }
        return rank;
    }
}
