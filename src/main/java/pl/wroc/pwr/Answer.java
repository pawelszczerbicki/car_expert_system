package pl.wroc.pwr;

import pl.wroc.pwr.car.FeatureType;

/**
 * Created by Pawel on 07.01.14.
 */
public class Answer {

    private FeatureType featureType;
    private Object answer;

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }
}
