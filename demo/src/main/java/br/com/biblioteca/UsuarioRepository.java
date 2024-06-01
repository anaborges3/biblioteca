package br.com.biblioteca;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends AbstractRepository<Usuario> {
    
    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, email, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setInt(4, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

