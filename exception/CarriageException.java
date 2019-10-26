package exception;

public class CarriageException extends Exception {
    @Override
    public String getMessage() {
        return "Already seen all the carriages of the train";
    }
}
