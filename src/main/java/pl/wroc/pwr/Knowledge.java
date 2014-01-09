package pl.wroc.pwr;

import org.springframework.stereotype.Component;

import java.util.*;

import static pl.wroc.pwr.Feature.*;
import static pl.wroc.pwr.FeatureType.*;
import static pl.wroc.pwr.FeatureType.ENGINE_CAPACITY;

/**
 * Created by Pawel on 04.01.14.
 */
@Component
public class Knowledge {

    private static List<Car> cars = new ArrayList<>();
    private static Map<FeatureType, Question> questions = new LinkedHashMap<>();

    static{
        cars.addAll(Arrays.asList(
                new Car("sample", "sample,", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, CABRIO),
                new Car("sample2", "sample2", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, SEDAN),
                new Car("sample3", "sample3", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, 2, COUPE, DIESEL)
        ));
        questions.put(CAR_TYPE, new Question(Type.MULTIANSWER, "What kind of car do you want?", SEDAN.toString(), CABRIO.toString(), COMBI.toString(), COUPE.toString(), VAN.toString(), LIMOUSYNE.toString(), HATCHBACK.toString(), SUV.toString()));
        questions.put(PETROL_TYPE, new Question(Type.MULTIANSWER, "what petrol?", GAS.toString(), PETROL.toString(), DIESEL.toString()));
        questions.put(ENGINE_CAPACITY, new Question(Type.OPEN, "What capacity"));

    }

    public Map<FeatureType, Question> getQuestions() {
        return questions;
    }

    public List<Car> getCars() {
        return cars;
    }
}
