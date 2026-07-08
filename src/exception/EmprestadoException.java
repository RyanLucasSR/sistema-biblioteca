package exception;

public class EmprestadoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Livro indisponível!!(Já emprestado)";
    }
}
