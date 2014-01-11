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

    public List<CarRank> resolve(List<Answer> answers) {
        Map<Car, Integer> rank = getRankMap();
        for (Answer a : answers)
            resolve(a, rank);

        return getCarRank(rank);
    }

    private List<CarRank> getCarRank(Map<Car, Integer> rank) {
         List<CarRank> carRanks = new ArrayList<>();
        for(Entry<Car, Integer> e : rank.entrySet())
            carRanks.add(new CarRank(e.getKey(), ((double)e.getValue())/knowledge.questionAmount()));
        Collections.sort(carRanks, new CarRankComparator());
        return carRanks;
    }

    private void resolve(Answer a, Map<Car, Integer> rank) {
        for (Entry<Car, Integer> e : rank.entrySet()) {
            e.setValue(e.getValue() + updateRank(a, e.getKey()));
        }
    }

    private Integer updateRank(Answer a, Car car) {
        Integer rank = 0;
        String answer = a.getAnswer();
        switch (a.getFeatureType()) {
            case ACCELERATION:
                if (car.getAcceleration() <= Integer.parseInt(answer)) rank++;
                break;
            case CAR_TYPE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case DOORS:
                if (car.getDoors().equals(Integer.parseInt(answer))) rank++;
                break;
            case ENGINE_CAPACITY:
                if (car.getCapacity().equals(Double.parseDouble(answer))) rank++;
                break;
            case FUEL_CONSUMPTION:
                if (car.getFuelConsumption() <= Double.parseDouble(answer)) rank++;
                break;
            case HORSE_POWER:
                if (car.getHorsePower() >= Double.parseDouble(answer)) rank++;
                break;
            case MAX_SPEED:
                if (car.getMaxSpeed() >= Integer.parseInt(answer)) rank++;
                break;
            case MOMENT:
                if (car.getMoment() >= Double.parseDouble(answer)) rank++;
                break;
            case PETROL_TYPE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case RAIL_TYPE:
                if (car.hasFeature(Feature.valueOf(answer))) rank++;
                break;
            case TURBO:
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
