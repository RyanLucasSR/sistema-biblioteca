package exception;

public class DevolucaoException extends RuntimeException {



    @Override
    public String getMessage() {
        return "Livro disponível!";
    }
}
