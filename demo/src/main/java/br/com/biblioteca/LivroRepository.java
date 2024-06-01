package br.com.biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository extends AbstractRepository<Livro> {
    
    @Override
    public void save(Livro livro) {
        String sql = "INSERT INTO Livro (titulo, autor, categoria, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getCategoria().name());
            pstmt.setString(4, "DISPONIVEL");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro findById(int id) {
        String sql = "SELECT * FROM Livro WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), 
                        Categoria.valueOf(rs.getString("categoria")), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Livro> findAll() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), 
                        Categoria.valueOf(rs.getString("categoria")), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    @Override
    public void update(Livro livro) {
        String sql = "UPDATE Livro SET titulo = ?, autor = ?, categoria = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getCategoria().name());
            pstmt.setString(4, livro.getStatus());
            pstmt.setInt(5, livro.getLivroId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Livro WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

