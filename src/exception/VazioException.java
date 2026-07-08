package exception;

public class VazioException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Livro não existente!";
    }
}
