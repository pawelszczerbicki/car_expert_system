package pl.wroc.pwr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pawel on 04.01.14.
 */
public class Question {

    private Type type;
    private String question;
    private List<String> answers = new ArrayList<>();

    public Question(Type type, String question, String... answers) {
        this.type = type;
        this.question = question;
        this.answers.addAll(Arrays.asList(answers));
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
