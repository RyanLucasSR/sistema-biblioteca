package biblioteca;

import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        RegrasBiblioteca regras = new RegrasBiblioteca();
        Menu menu = new Menu();
        Scanner entrada = new Scanner(System.in);

        int escolha = 0;

        while (escolha != 4) {
            System.out.println(menu.mostarMenu());
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Titulo:");
                    String titulo = entrada.nextLine();

                    System.out.println("Autor:");
                    String autor = entrada.nextLine();

                    regras.cadastroLivros(titulo, autor);

                    System.out.println("Cadastro concluido!");
                    break;

                case 2:
                    regras.listarLivros();

                    System.out.println("Fim lista!");
                    break;

                case 3:
                    System.out.println("Qual livro deseja pesquisar?");
                    String livroPesquisa = entrada.nextLine();
                    String resultado = regras.obterLivro(livroPesquisa);

                    if(resultado != null){
                        System.out.println(resultado);
                        System.out.println("Pesquisa encontrada!");

                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Inválido!");
            }
        }
        entrada.close();
    }
}
