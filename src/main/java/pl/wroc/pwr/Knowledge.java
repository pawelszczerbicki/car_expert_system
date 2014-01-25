package pl.wroc.pwr;

import org.springframework.stereotype.Component;
import pl.wroc.pwr.car.Car;
import pl.wroc.pwr.car.Feature;
import pl.wroc.pwr.car.FeatureType;

import java.util.*;

import static pl.wroc.pwr.car.Feature.*;
import static pl.wroc.pwr.car.FeatureType.*;
import static pl.wroc.pwr.car.FeatureType.HORSE_POWER;
import static pl.wroc.pwr.car.FeatureType.MOMENT;

/**
 * Created by Pawel on 04.01.14.
 */
@Component
public class Knowledge {

    private static final String PHOTO_SUFFIX = "/resources/img/";
    private static List<Car> cars = new ArrayList<>();
    private static Map<FeatureType, Question> questions = new LinkedHashMap<>();

    static {
        cars.addAll(Arrays.asList(
                new Car("Toyota", "Auris", 68000d, 5.5, 200, 10.0, 136d, 160d, 1.6, 5, 354, getPhoto("auris.jpeg"), HATCHBACK, PETROL, GAS, RAIL_FRONT, CITY, FAMILY, MANUAL),
                new Car("Skoda", "Octavia", 75000d, 5.0, 218, 8.5, 150d, 320d, 2.0, 5, 560, getPhoto("octavia.jpg"), LIFTBACK, DIESEL, RAIL_FRONT, FAMILY, CITY, MANUAL, Feature.TURBO),
                new Car("Volkswagen", "Golf", 64000d, 5.2, 212, 8.4, 140d, 250d, 1.4, 5, 380, getPhoto("golf.jpg"), HATCHBACK, PETROL, GAS, RAIL_FRONT, FAMILY, CITY, MANUAL),
                new Car("Opel", "Astra GTC", 85000d, 7.2, 220, 8.3, 180d, 230d, 1.6, 3, 370, getPhoto("astra_gtc.jpg"), HATCHBACK, PETROL, RAIL_FRONT, SPORT, MANUAL, Feature.TURBO),
                new Car("Volkswagen", "Passat", 95000d, 5.8, 215, 9.0, 170d, 230d, 2.0, 5, 565, getPhoto("passat.jpg"), SEDAN, DIESEL, FAMILY, CITY, MANUAL, AUTOMAT, Feature.TURBO),
                new Car("Mazda", "6", 105000d, 6.2, 216, 9.1, 165d, 210d, 2.0, 5, 500, getPhoto("mazda.jpeg"), SEDAN, PETROL, RAIL_FRONT, FAMILY, SPORT, BUSINESS, MANUAL, AUTOMAT),
                new Car("Ford", "Mondeo", 86000d, 5.3, 220, 8.9, 163d, 340d, 2.0, 5, 460, getPhoto("mondeo.jpg"), SEDAN, DIESEL, RAIL_FRONT, FAMILY, CITY, MANUAL, AUTOMAT, Feature.TURBO),
                new Car("BMW", "3 Series", 128000d, 5.8, 235, 7.5, 184d, 380d, 2.0, 5, 480, getPhoto("bmw3.jpg"), SEDAN, DIESEL, RAIL_REAR, SPORT, BUSINESS, MANUAL, AUTOMAT, Feature.TURBO),
                new Car("Audi", "A4", 120000d, 5.8, 226, 8.7, 170d, 230d, 2.0, 5, 440, getPhoto("audia4.jpg"), SEDAN, DIESEL, RAIL_FRONT, FAMILY, CITY, MANUAL, AUTOMAT, Feature.TURBO),
                new Car("Toyota", "RAV4", 123000d, 6.8, 190, 9.6, 150d, 340d, 2.2, 5, 469, getPhoto("toyotarav4.jpg"), SUV, DIESEL, RAIL_4, TERRAIN, FAMILY, CITY, AUTOMAT, MANUAL, Feature.TURBO),
                new Car("Nissan", "Qashqai", 75000d, 6.5, 199, 9.0, 150d, 240d, 1.6, 5, 410, getPhoto("nissan_qashqai.jpg"), SUV, PETROL, RAIL_FRONT, FAMILY, CITY, TERRAIN, MANUAL, AUTOMAT),
                new Car("Nissan", "370Z", 192000d, 10.6, 250, 5.2, 344d, 371d, 3.7, 2, 235, getPhoto("nissan-370z.jpg"), COUPE, PETROL, RAIL_REAR, SPORT, MANUAL, AUTOMAT, Feature.TURBO),
                new Car("Mazda", "MX-5", 115000d, 7.8, 218, 7.9, 160d, 188d, 2.0, 2, 144, getPhoto("mazda-mx5.jpg"), ROADSTER, PETROL, RAIL_REAR, SPORT, CITY, MANUAL, AUTOMAT)
        ));

        questions.put(CAR_PURPOSE, new Question(CAR_PURPOSE, Type.MULTIANSWER, "What is purpose of the car?", CITY.toString(), SPORT.toString(), TERRAIN.toString(), BUSINESS.toString(), FAMILY.toString()));
        questions.put(FeatureType.PRICE, new Question(FeatureType.PRICE, Type.MULTIANSWER, "What price ? [PLN]", "30000-60000", "61000-90000", "91000-120000", "121000-150000", "151000-500000"));
        questions.put(FUEL, new Question(FUEL, Type.MULTIANSWER, "What fuel type?", GAS.toString(), PETROL.toString(), DIESEL.toString()));
        questions.put(CAR_TYPE, new Question(CAR_TYPE, Type.MULTIANSWER, "What kind of car do you want?", SEDAN.toString(), CABRIO.toString(), COMBI.toString(), COUPE.toString(), VAN.toString(), LIMOUSINE.toString(), HATCHBACK.toString(), SUV.toString(), LIFTBACK.toString(), ROADSTER.toString()));
        questions.put(TRUNK, new Question(TRUNK, Type.MULTIANSWER, "What trunk capacity do zou want? [L]", "120-250", "250-350", "350-400", "400-500", "500-700"));
        questions.put(DOORS, new Question(DOORS, Type.MULTIANSWER, "How many doors do you want", "2", "5"));
        questions.put(GEAR_BOX, new Question(GEAR_BOX, Type.MULTIANSWER, "What type of gearbox do you want", MANUAL.toString(), AUTOMAT.toString()));
        questions.put(RAIL_TYPE, new Question(RAIL_TYPE, Type.MULTIANSWER, "What kind of rail?", RAIL_4.toString(), RAIL_FRONT.toString(), RAIL_REAR.toString()));
        questions.put(FeatureType.ENGINE_CAPACITY, new Question(FeatureType.ENGINE_CAPACITY, Type.MULTIANSWER, "What is engine size", "1.0-1.5", "1.6-1.9", "2.0-2.5", "2.5-5.0"));
        questions.put(FeatureType.TURBO, new Question(FeatureType.TURBO, Type.MULTIANSWER, "Do you want turbo?", "Yes", "No"));
        questions.put(FeatureType.FUEL_CONSUMPTION, new Question(FeatureType.FUEL_CONSUMPTION, Type.MULTIANSWER, "What fuel consumption do you accept? [L]", "0-5.5", "5.6-8.5", "8.6-12", "12-15", "15-25"));
        questions.put(FeatureType.MAX_SPEED, new Question(FeatureType.MAX_SPEED, Type.MULTIANSWER, "What is max speed that you wand to? [km/h]", "100-170", "180-220", "220-250", "250-320"));
        questions.put(FeatureType.ACCELERATION, new Question(FeatureType.ACCELERATION, Type.MULTIANSWER, "What acceleration do you want to 100 km/h? [s]", "15-10", "10-7", "7-5", "5-2"));
        questions.put(HORSE_POWER, new Question(HORSE_POWER, Type.MULTIANSWER, "What horse power do you want?", "50-80", "80-120", "120-160", "160-190", "190-220", "220-260", "260-350"));
        questions.put(MOMENT, new Question(MOMENT, Type.MULTIANSWER, "What moment do you want? [Nm]", "100-150", "150-170", "170-200", "200-220", "220-250", "250-300", "300-350", "350-400"));

    }

    private static String getPhoto(String s) {
        return PHOTO_SUFFIX + s;
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