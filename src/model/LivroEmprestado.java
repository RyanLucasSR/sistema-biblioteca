package model;

public class LivroEmprestado extends Livro {

    boolean emprestado;

    public LivroEmprestado(String titulo, String descricao, int idLivro) {
        super(titulo, descricao, idLivro);
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

}
