package pl.wroc.pwr.response;

/**
 * Created by Pawel on 08.01.14.
 */
public abstract class JsonResponse<T> {

    private String status;

    private T questions;

    protected JsonResponse(String status, T questions) {
        this.status = status;
        this.questions = questions;
    }

    public String getStatus() {
        return status;
    }

    public T getQuestions() {
        return questions;
    }
}
