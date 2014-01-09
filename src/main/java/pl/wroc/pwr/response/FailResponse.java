package pl.wroc.pwr.response;

/**
 * Created by Pawel on 08.01.14.
 */
public class FailResponse<T> extends JsonResponse<T> {

    public static final String FAIL = "fail";

    public FailResponse() {
        this(null);
    }

    private FailResponse(T data) {
        super(FAIL, data);
    }

    public static <T> FailResponse<T> create(T data) {
        return new FailResponse<>(data);
    }
}
