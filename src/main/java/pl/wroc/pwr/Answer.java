package pl.wroc.pwr;

import pl.wroc.pwr.car.FeatureType;

/**
 * Created by Pawel on 07.01.14.
 */
public class Answer {

    private FeatureType featureType;
    private String answer;

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "featureType=" + featureType +
                ", answer='" + answer + '\'' +
                '}';
    }
}
