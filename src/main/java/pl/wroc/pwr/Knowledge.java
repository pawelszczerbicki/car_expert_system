package pl.wroc.pwr;

import org.springframework.stereotype.Component;

import java.util.*;

import static pl.wroc.pwr.Feature.*;

/**
 * Created by Pawel on 04.01.14.
 */
@Component
public class Knowledge {

    private static List<Car> cars= new ArrayList<>();
    private static Map<Feature, Question> questions = new LinkedHashMap<>(); //TODO sort or not????

    static{
        cars.addAll(Arrays.asList(
                new Car("sample", "sample,", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, CABRIO),
                new Car("sample2", "sample2", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, SEDAN),
                new Car("sample3", "sample3", 222.0, 8.3, 245, 11.2, 125.3, 11300.0, 1.9, COUPE, DIESEL)
        ));
    }

    public List<Car> getCars() {
        return cars;
    }
}
