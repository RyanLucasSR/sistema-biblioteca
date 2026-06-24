package view;

import controller.ControladorBiblioteca;

import java.util.Scanner;

public class BibliotecaConsole {

    ControladorBiblioteca control = new ControladorBiblioteca();
    Scanner entrada = new Scanner(System.in);

    Menu menu = new Menu();

    public void iniciar(){
        boolean continuar = true;
        int opcao = 0;

        do{
            System.out.println(menu.mostrarMenu());
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String titulo = entrada.nextLine().trim();

                    System.out.println("Digite o nome do autor: ");
                    String autor = entrada.nextLine().trim();

                    control.adicionarLivros(titulo,autor);
                    break;

                case 2:
                    control.listarLivros();
                    break;

                case 3:
                    System.out.println("Digite o nome do livro: ");
                    titulo = entrada.nextLine().trim();

                    control.buscarLivro(titulo);
                    break;

                case 4:
                    System.out.println("Digite o nome do livro: ");
                    titulo = entrada.nextLine().trim();

                    control.remover(titulo);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Valor ínvalido!");
            }
        }while(continuar)  ;
    }
}
