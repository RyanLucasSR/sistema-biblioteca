package biblioteca;

public class CadastroLivros{

    public String nome;
    public String autor;

    public CadastroLivros(String nome, String autor){
        this.nome = nome;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo: " + nome + "\nAutor: " + autor + "\n";
    }
}
