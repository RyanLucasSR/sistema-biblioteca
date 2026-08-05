package dao;

import exception.LivroException;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    Connection conexao = FabricaDeConexao.getConexao();

    public void inserirLivro(Livro livro) throws SQLException {
        String insert = "INSERT INTO biblioteca(titulo, autor, disponivel) VALUES (?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(insert);

        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setBoolean(3, livro.isStatusLivro());

        if (stmt.executeUpdate() == 0) {
            throw new LivroException("Livro não adicionado!");

        }

        stmt.close();
    }

    public List<Livro> listarLivros() throws SQLException {
        String select = "SELECT * FROM biblioteca";

        List<Livro> livros = new ArrayList<>();

        PreparedStatement stmt = conexao.prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int id = rs.getInt("id");
            boolean statusLivro = rs.getBoolean("disponivel");

            livros.add(new Livro(id, titulo, autor, statusLivro));
        }

        stmt.close();
        return livros;
    }


    public List<Livro> pesquisarLivros(String titulo) throws SQLException {
        String select = "SELECT * FROM biblioteca WHERE titulo LIKE ?";

        List<Livro> livros = new ArrayList<>();

        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setString(1, '%' + titulo + '%');

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            String tituloAchado = rs.getString("titulo");
            String autor = rs.getString("autor");
            int id = rs.getInt("id");
            boolean statusLivro = rs.getBoolean("disponivel");

            livros.add(new Livro(id, tituloAchado, autor, statusLivro));
        }

        stmt.close();
        return livros;
    }

    public Livro consultarLivro(int id) throws SQLException {
        String select = "SELECT * FROM biblioteca WHERE id = ?";

        Livro livroAchado = null;

        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int idAchado = rs.getInt("id");
            boolean statusLivro = rs.getBoolean("disponivel");

            livroAchado = new Livro(idAchado, titulo, autor, statusLivro);
        }else{
            throw new LivroException("Livro não encontrado!");
        }

        stmt.close();
        return livroAchado;
    }

    public void atualizarLivro(int id, String titulo, String autor, boolean statusLivro) throws SQLException {
        String update = "UPDATE biblioteca SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(update);
        stmt.setString(1, titulo);
        stmt.setString(2, autor);
        stmt.setBoolean(3, statusLivro);
        stmt.setInt(4, id);

        if (stmt.executeUpdate() == 0) {
            throw new LivroException("Livro não atualizado!");
        }
        stmt.close();
    }

    public void excluirLivro(int id) throws SQLException {
        String delete = "DELETE FROM biblioteca WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(delete);
        stmt.setInt(1, id);

        if (stmt.executeUpdate() == 0) {
            throw new LivroException("Não foi possivel deletar!");
        }

        stmt.close();
    }

    //TODO implementar emprestimo e devolução

    public void emprestarLivro(String titulo) throws SQLException {

        String update = "UPDATE biblioteca SET disponivel = ? WHERE titulo = ?";

        PreparedStatement stmt = conexao.prepareStatement(update);
        stmt.setBoolean(1, false);
        stmt.setString(2, titulo);

        if (stmt.executeUpdate() == 0) {
            throw new LivroException("Livro não emprestado!");
        }

        stmt.close();
    }
    public void devolverLivro(String titulo) throws SQLException {

        String update = "UPDATE biblioteca SET disponivel = ? WHERE titulo = ?";

        PreparedStatement stmt = conexao.prepareStatement(update);
        stmt.setBoolean(1, true);
        stmt.setString(2, titulo);

        if (stmt.executeUpdate() == 0) {
            throw new LivroException("Livro não devolvido!");
        }

        stmt.close();
    }
}
