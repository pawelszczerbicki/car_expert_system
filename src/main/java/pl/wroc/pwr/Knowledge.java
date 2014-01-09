package pl.wroc.pwr;

import org.springframework.stereotype.Component;
import pl.wroc.pwr.car.Car;
import pl.wroc.pwr.car.FeatureType;

import java.util.*;

import static pl.wroc.pwr.car.Feature.*;
import static pl.wroc.pwr.car.FeatureType.*;
import static pl.wroc.pwr.car.FeatureType.ENGINE_CAPACITY;

/**
 * Created by Pawel on 04.01.14.
 */
@Component
public class Knowledge {

    private static final String PHOTO_SUFFIX = "/resources/img/";
    private static List<Car> cars = new ArrayList<>();
    private static Map<FeatureType, Question> questions = new LinkedHashMap<>();

    static{
        cars.addAll(Arrays.asList(
                new Car("sample", "sample,", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, CABRIO),
                new Car("sample2", "sample2", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, SEDAN),
                new Car("sample3", "sample3", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, COUPE, DIESEL)
        ));
        questions.put(CAR_TYPE, new Question(CAR_TYPE, Type.MULTIANSWER, "What kind of car do you want?", SEDAN.toString(), CABRIO.toString(), COMBI.toString(), COUPE.toString(), VAN.toString(), LIMOUSYNE.toString(), HATCHBACK.toString(), SUV.toString()));
        questions.put(PETROL_TYPE, new Question(PETROL_TYPE, Type.MULTIANSWER, "what petrol?", GAS.toString(), PETROL.toString(), DIESEL.toString()));
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
