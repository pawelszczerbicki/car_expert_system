package pl.wroc.pwr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pawel on 04.01.14.
 */
public class Question {

    private String question;
    private List<String> answers = new ArrayList<>();

    public Question(String question, String answers) {
        this.question = question;
        this.answers.addAll(Arrays.asList(answers));
    }

    public String getQuestion() {
        return question;
    }
}
