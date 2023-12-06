package pl.kurs.exception;

public class KidNotFoundException  extends RuntimeException {

    public KidNotFoundException() {
    }

    public KidNotFoundException(String message) {
        super(message);
    }
}
