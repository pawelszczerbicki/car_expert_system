package pl.wroc.pwr.response;

/**
 * Created by Pawel on 08.01.14.
 */
public abstract class JsonResponse<T> {

    private String status;

    private T data;

    protected JsonResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
