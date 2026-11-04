package mx.edu.utez.MT09_Angel_Brito_CA2.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}