package exception;

public class LivroException extends RuntimeException {
    public LivroException(String message) {
        System.out.println(message);
    }
}
