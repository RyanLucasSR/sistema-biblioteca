package view;

public class Menu {

    public String mostrarMenu(){
        return "=====================\n"
                + "      Biblioteca     "
                + "\n=====================\n" +
                "[1] cadastro livro" +
                "\n[2] listar livros" +
                "\n[3] pesquisar titulo" +
                "\n[4] remover livro\n" +
                "[0] Sair" +
                "\n=====================";
    }
}
