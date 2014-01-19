package pl.wroc.pwr;

import org.springframework.stereotype.Component;
import pl.wroc.pwr.car.Car;
import pl.wroc.pwr.car.FeatureType;

import java.util.*;

import static pl.wroc.pwr.car.Feature.*;
import static pl.wroc.pwr.car.FeatureType.CAR_TYPE;
import static pl.wroc.pwr.car.FeatureType.PETROL_TYPE;
import static pl.wroc.pwr.car.FeatureType.RAIL_TYPE;

/**
 * Created by Pawel on 04.01.14.
 */
@Component
public class Knowledge {

    private static final String PHOTO_SUFFIX = "/resources/img/";
    private static List<Car> cars = new ArrayList<>();
    private static Map<FeatureType, Question> questions = new LinkedHashMap<>();

    static {
        // public Car(String make, String model, Double price, Double fuelConsumption, Integer maxSpeed, Double acceleration, Double horsePower, Double moment, Double capacity, Integer doors, Feature... features) {
        // top 50 source : http://www.auto-motor-i-sport.pl/wiadomosci/top-50-ranking-najpopularniejsze-auta-w-Polsce,15807,1
        cars.addAll(Arrays.asList(
                new Car("Toyota", "Auris", 68000d, 5.5, 200, 10.0, 136d, 160d, 1.6, 5, HATCHBACK, PETROL, RAIL_FRONT),
                new Car("Skoda", "Octavia", 75000d, 5.0, 218, 8.5, 150d, 320d, 2.0, 5, LIFTBACK, DIESEL, RAIL_FRONT),
                new Car("Volkswagen", "Golf", 64000d, 5.2, 212, 8.4, 140d, 250d, 1.4, 5, HATCHBACK, PETROL, RAIL_FRONT),
                new Car("Opel", "Astra GTC", 85000d, 7.2, 220, 8.3, 180d, 230d, 1.6, 3, HATCHBACK, PETROL, RAIL_FRONT),
                new Car("Volkswagen", "Passat", 95000d, 5.8, 215, 9.0, 170d, 230d, 2.0, 5, SEDAN, DIESEL),
                new Car("Mazda", "6", 105000d, 6.2, 216, 9.1, 165d, 210d, 2.0, 5, SEDAN, PETROL, RAIL_FRONT),
                new Car("Ford", "Mondeo", 86000d, 5.3, 220, 8.9, 163d, 340d, 2.0, 5, SEDAN, DIESEL, RAIL_FRONT),
                new Car("BMW", "3", 128000d, 5.8, 235, 7.5, 184d, 380d, 2.0, 5, SEDAN, DIESEL, RAIL_REAR),
                new Car("Audi", "A4", 120000d, 5.8, 226, 8.7, 170d, 230d, 2.0, 5, SEDAN, DIESEL, RAIL_FRONT),
                new Car("Toyota", "RAV4", 123000d, 6.8, 190, 9.6, 150d, 340d, 2.2, 5, SUV, DIESEL, RAIL_4),
                new Car("Nissan", "Qashqai", 75000d, 6.5, 199, 9.0, 150d, 240d, 1.6, 5, SUV, PETROL, RAIL_FRONT),
                new Car("Nissan", "370Z", 192000d, 10.6, 250, 5.2, 344d, 371d, 3.7, 2, COUPE, PETROL, RAIL_REAR),
                new Car("Mazda", "MX-5", 115000d, 7.8, 218, 7.9, 160d, 188d, 2.0, 2, ROADSTER, PETROL, RAIL_REAR)
        ));
        questions.put(CAR_TYPE, new Question(CAR_TYPE, Type.MULTIANSWER, "What kind of car do you want?", SEDAN.toString(), CABRIO.toString(), COMBI.toString(), COUPE.toString(), VAN.toString(), LIMOUSYNE.toString(), HATCHBACK.toString(), SUV.toString(), LIFTBACK.toString(), ROADSTER.toString()));
        questions.put(PETROL_TYPE, new Question(PETROL_TYPE, Type.MULTIANSWER, "what petrol?", GAS.toString(), PETROL.toString(), DIESEL.toString()));
        questions.put(RAIL_TYPE, new Question(RAIL_TYPE, Type.MULTIANSWER, "What kind of rail?", RAIL_4.toString(), RAIL_FRONT.toString(), RAIL_REAR.toString()));
//        questions.put(ENGINE_CAPACITY, new Question(ENGINE_CAPACITY,Type.OPEN, "What capacity"));

    }

    public Map<FeatureType, Question> getQuestions() {
        return questions;
    }

    public List<Car> getCars() {

        return cars;
    }

    public Integer questionAmount() {
        return questions.size();
    }
}