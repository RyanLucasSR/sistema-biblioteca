package view;

import exception.LivroException;
import exception.VazioException;
import service.RegrasBiblioteca;

import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaConsole {

    RegrasBiblioteca regras = new RegrasBiblioteca();
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

                    try {
                        regras.cadastroLivros(titulo, autor, true);
                        System.out.println("Livro cadastrado com sucesso!");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    try{
                        regras.listarLivros().forEach(System.out::println);
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("Digite o nome do livro: ");
                    String tituloBusca = entrada.nextLine().trim();

                    try {
                        regras.pesquisarLivro(tituloBusca).forEach(System.out::println);
                        System.out.println("Livro buscado com sucesso!");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("Digite o id do livro: ");
                    int id = entrada.nextInt();

                    try{
                        regras.removerLivro(id);
                        System.out.println("Livro removido com sucesso!");
                    }catch (VazioException | SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:
                    System.out.println("Digite o id do livro: ");
                    id = entrada.nextInt();

                    try{
                        System.out.println(regras.consultarLivro(id));
                        System.out.println("Livro consultado com sucesso!");
                    }catch (SQLException | VazioException e){
                        System.out.println(e.getMessage());
                    }

                    entrada.nextLine();
                    System.out.println("Dejesa atualizar? ");
                    String atualizar = entrada.nextLine().trim();

                    if(atualizar.equalsIgnoreCase("S") ||
                            atualizar.equalsIgnoreCase("sim")){

                        System.out.println("Digite o nome do livro: ");
                        String novoNome = entrada.nextLine().trim();

                        System.out.println("Digite o nome do autor: ");
                        String novoAutor = entrada.nextLine().trim();

                        try {
                            regras.atualizarLivro(id, novoNome, novoAutor, true);
                            System.out.println("Livro atualizado com sucesso!");
                        }catch (VazioException | SQLException e){
                            System.out.println(e.getMessage());
                        }
                    }else{
                        break;
                    }

                    break;

                case 6:
                    System.out.println("Digite o id: ");
                    int idEmprestimo = entrada.nextInt();

                    try{
                        regras.emprestarLivro(idEmprestimo);
                        System.out.println("Livro emprestado com sucesso!");
                    }catch (VazioException | SQLException | LivroException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 7:
                    System.out.println("Digite o id: ");
                        int idDevolucao = entrada.nextInt();

                    try{
                        regras.devolverLivro(idDevolucao);
                        System.out.println("Livro devolvido com sucesso!");
                    }catch (VazioException | SQLException | LivroException e){
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
