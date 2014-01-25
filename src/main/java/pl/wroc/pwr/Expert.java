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

    public List<CarRank> resolve(List<Answer> answers) {
        answeredQuestions = 0;
        Map<Car, Integer> rank = getRankMap();
        for (Answer a : answers)
            resolve(a, rank);

        return getCarRank(rank);
    }

    private List<CarRank> getCarRank(Map<Car, Integer> rank) {
        List<CarRank> carRanks = new ArrayList<>();
        for (Entry<Car, Integer> e : rank.entrySet())
            carRanks.add(new CarRank(e.getKey(), ((double) e.getValue()*100) / answeredQuestions));
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
        double start;
        double stop;
        switch (a.getFeatureType()) {
            case ACCELERATION:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getAcceleration() >= start && car.getAcceleration() <= stop) rank++;
                break;
            case CAR_TYPE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case DOORS:
                if (car.getDoors().equals(Integer.parseInt(answer))) rank++;
                break;
            case ENGINE_CAPACITY:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getCapacity() >= start && car.getCapacity() <= stop) rank++;
                break;
            case FUEL_CONSUMPTION:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getFuelConsumption() >= start && car.getFuelConsumption() <= stop) rank++;
                break;
            case HORSE_POWER:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getHorsePower() >= start && car.getHorsePower() <= stop) rank++;
                break;
            case MAX_SPEED:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getMaxSpeed() >= start && car.getMaxSpeed() <= stop) rank++;
                break;
            case MOMENT:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getMoment() >= start && car.getMoment() <= stop) rank++;
                break;
            case PRICE:
                start = Double.parseDouble(answer.split(DELIMITER)[0]);
                stop = Double.parseDouble(answer.split(DELIMITER)[1]);
                if (car.getPrice() >= start && car.getPrice() <= stop) rank++;
                break;
            case TRUNK:
                start = Integer.parseInt(answer.split(DELIMITER)[0]);
                stop = Integer.parseInt(answer.split(DELIMITER)[1]);
                if (car.getTrunk() >= start && car.getTrunk() <= stop) rank++;
                break;
            case FUEL:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case RAIL_TYPE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case TURBO:
                if (car.hasFeature(Feature.TURBO) && answer.equalsIgnoreCase("Yes")) rank++;
                if (!car.hasFeature(Feature.TURBO) && answer.equalsIgnoreCase("No")) rank++;
                break;
            case GEAR_BOX:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case CAR_PURPOSE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
        }
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
