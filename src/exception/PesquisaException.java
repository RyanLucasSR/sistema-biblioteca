package exception;

public class PesquisaException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Livro não encontrado!";
    }
}
