package exc;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super();
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }



    public UserException(Throwable cause) {
        super(cause);
    }
}
