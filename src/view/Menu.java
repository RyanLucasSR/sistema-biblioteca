package view;

public class Menu {

    public String mostrarMenu(){
        return "======================\n"
                + "      Biblioteca     "
                + "\n======================\n" +
                "[1] Cadastro livro" +
                "\n[2] Listar livros" +
                "\n[3] Pesquisar titulo" +
                "\n[4] Remover livro" +
                "\n[5] Atualizar livro" +
                "\n[6] Emprestar livro" +
                "\n[7] Devolver livro" +
                "\n[0] Sair" +
                "\n======================\n";
    }
}
