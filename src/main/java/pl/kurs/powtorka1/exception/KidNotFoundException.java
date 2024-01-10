package pl.kurs.powtorka1.exception;

public class KidNotFoundException  extends RuntimeException {

    public KidNotFoundException() {
    }

    public KidNotFoundException(String message) {
        super(message);
    }
}
