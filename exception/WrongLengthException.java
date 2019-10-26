package exception;

public class WrongLengthException extends RuntimeException {
    private String message;

    public WrongLengthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}