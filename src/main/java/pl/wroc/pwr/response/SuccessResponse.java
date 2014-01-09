package pl.wroc.pwr.response;

/**
 * Created by Pawel on 08.01.14.
 */
public class SuccessResponse<T> extends JsonResponse<T> {

    public static final String SUCCESS = "success";

    public SuccessResponse() {
        this(null);
    }

    private SuccessResponse(T data) {
        super(SUCCESS, data);
    }

    public static <T> SuccessResponse<T> create(T data) {
        return new SuccessResponse<>(data);
    }
}
