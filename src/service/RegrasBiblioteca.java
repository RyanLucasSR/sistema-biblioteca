package service;

import dao.LivroDAO;
import exception.VazioException;
import model.Livro;

import java.sql.SQLException;
import java.util.List;

public class RegrasBiblioteca {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastroLivros(String titulo, String autor, boolean statusLivro) throws SQLException {

        if(titulo == null || titulo.isBlank() || autor == null || autor.isBlank()) {
            throw new VazioException();
        }

        Livro livro = new Livro(titulo, autor, statusLivro);

        livroDAO.inserirLivro(livro);
    }

    public List<Livro> listarLivros() throws SQLException {
        return livroDAO.listarLivros();
    }

    public List<Livro> pesquisarLivro(String titulo) throws SQLException {

        if(titulo == null | titulo.isBlank()) {
            throw new VazioException();
        }

        return livroDAO.pesquisarLivros(titulo);
    }

    //TODO refaorar com usuario adicionando sim para atualizar
    public void atualizarLivro(int id, String titulo, String autor, boolean statusLivro) throws SQLException {

        if(titulo == null || titulo.isBlank() || autor == null || autor.isBlank() | id <= 0) {
            throw new VazioException();
        }

        Livro livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        livroDAO.atualizarLivro(id, titulo, autor, statusLivro);
    }

    public void removerLivro(int id) throws SQLException {

        if(id <= 0){
            throw new VazioException();
        }

        Livro livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        livroDAO.excluirLivro(id);
    }

    public Livro consultarLivro(int id) throws SQLException {

        if(id <= 0){
            throw new VazioException();
        }

        return livroDAO.consultarLivro(id);
    }

    //TODO implementar emprestimo e devolução
//   public void emprestarLivro(String titulo){
//       boolean existeLivro = lista.stream().anyMatch(l -> l.getTitulo().equalsIgnoreCase(titulo));
//
//       if(!lista.isEmpty() && !existeLivro) {
//           throw new VazioException();
//       }
//
//       lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
//               .forEach(l -> l.setEmprestimo());
//   }
//
//   public void devolucaoLivro(String titulo) {
//       boolean existeLivro = lista.stream().anyMatch(l -> l.getTitulo().equalsIgnoreCase(titulo));
//
//       if(!lista.isEmpty() && !existeLivro) {
//           throw new VazioException();
//       }
//
//       lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
//               .forEach(l -> l.setDevolucao());
//   }

}
