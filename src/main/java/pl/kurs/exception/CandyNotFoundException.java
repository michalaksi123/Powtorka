package pl.kurs.exception;

public class CandyNotFoundException extends RuntimeException {

    public CandyNotFoundException() {
    }

    public CandyNotFoundException(String message) { super(message);}
}
