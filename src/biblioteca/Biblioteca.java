package biblioteca;

import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        RegrasBiblioteca regras = new RegrasBiblioteca();
        Menu menu = new Menu();
        Scanner entrada = new Scanner(System.in);

        int escolha = 0;

        while (escolha != 5) {
            System.out.println(menu.mostrarMenu());
            escolha = entrada.nextInt();
            entrada.nextLine();//->tirar o bug do nextline

            switch (escolha) {
                case 1:
                    System.out.println("Titulo: ");
                    String titulo = entrada.nextLine().trim();

                    System.out.println("Autor: ");
                    String autor = entrada.nextLine().trim();

                    regras.cadastroLivros(titulo, autor);
                    break;

                case 2:
                    regras.listarLivros();
                    break;

                case 3:
                    System.out.println("Qual livro deseja pesquisar?");
                    String livroPesquisa = entrada.nextLine().trim().toLowerCase();
                    regras.pesquisarLivro(livroPesquisa);
                    break;

                case 4:
                    System.out.println("Qual livros deseja excluir: ");
                    String livroExcluir = entrada.nextLine();
                    regras.removerLivro(livroExcluir);

                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Inválido!");
            }
        }
        entrada.close();
    }
}
