package view;

import controller.ControladorBiblioteca;
import exception.PesquisaException;
import exception.VazioException;

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
            try{
                opcao = entrada.nextInt();

            }catch (VazioException e){
                System.out.println("Valor invalido!");

            }
            entrada.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String titulo = entrada.nextLine().trim();

                    System.out.println("Digite o nome do autor: ");
                    String autor = entrada.nextLine().trim();

                    control.adicionarLivros(titulo,autor);
                    break;

                case 2:
                    try{
                        control.listarLivros();
                    }catch (VazioException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do livro: ");
                    String tituloBusca = entrada.nextLine().trim();

                    try {
                        control.buscarLivro(tituloBusca);
                    }catch (PesquisaException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do livro: ");
                    titulo = entrada.nextLine().trim();

                    try{
                        control.remover(titulo);
                    }catch (VazioException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome do livro: ");
                    titulo = entrada.nextLine().trim();

                    try{
                        control.EmprestarLivro(titulo);
                    }catch (VazioException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Digite o nome do livro: ");
                    titulo = entrada.nextLine().trim();

                    try{
                        control.devolverLivro(titulo);
                    }catch (VazioException e){
                        System.out.println(e.getMessage());
                    }
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
