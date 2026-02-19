package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<CadastroLivros> lista = new ArrayList<>();

        int menu = 0;

        while(menu != 3) {
            System.out.println("===================");
            System.out.println("     Biblioteca    ");
            System.out.println("===================");
            System.out.println("[1] cadastro livro");
            System.out.println("[2] listar livros");
            System.out.println("[3] sair");
            System.out.println("===================");
            menu = entrada.nextInt();
            entrada.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Titulo: ");
                    String titulo = entrada.nextLine();

                    System.out.println("Autor: ");
                    String autor = entrada.nextLine();

                    lista.add(new CadastroLivros(titulo, autor));
                    System.out.println("Cadastro concluido!");
                    break;

                case 2:
                    System.out.println("=======================");

                    for(CadastroLivros livros : lista) {
                        System.out.println(livros);
                    }

                    System.out.println("=======================");
                    break;

                case 3:
                    System.out.println("Saindo....");
                    break;

                default:
                    System.out.println("Inválido!");
            }
        }
        entrada.close();
    }
}
