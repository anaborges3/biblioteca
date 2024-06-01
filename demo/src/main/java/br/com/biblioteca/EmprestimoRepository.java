package br.com.biblioteca;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.Livro;
import br.com.biblioteca.Emprestimo;

public class EmprestimoRepository extends AbstractRepository<Emprestimo> {
    
    @Override
    public void save(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimo (livro_id, usuario_id, dataEmprestimo, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, emprestimo.getEmprestimoLivro());
            pstmt.setInt(2, emprestimo.getEmprestimoUsuario());
            pstmt.setDate(3, Date.valueOf(LocalDate.now()));
            pstmt.setString(4, "EMPRESTADO");
            pstmt.executeUpdate();
            updateLivroStatus(emprestimo.getEmprestimoLivro(), "EMPRESTADO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void devolverLivro(int emprestimoId) {
        String sql = "UPDATE Emprestimo SET dataDevolucao = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(LocalDate.now()));
            pstmt.setString(2, "DEVOLVIDO");
            pstmt.setInt(3, emprestimoId);
            pstmt.executeUpdate();
            Emprestimo emprestimo = findById(emprestimoId);
            updateLivroStatus(emprestimo.getEmprestimoLivro(), "DISPONIVEL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emprestimo findById(int id) {
        String sql = "SELECT * FROM Emprestimo WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Emprestimo(rs.getInt("id"), rs.getInt("livro_id"), rs.getInt("usuario_id"),
                        rs.getDate("dataEmprestimo").toLocalDate(), rs.getDate("dataDevolucao") != null ? rs.getDate("dataDevolucao").toLocalDate() : null,
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emprestimo> findAll() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                emprestimos.add(new Emprestimo(rs.getInt("id"), rs.getInt("livro_id"), rs.getInt("usuario_id"),
                        rs.getDate("dataEmprestimo").toLocalDate(), rs.getDate("dataDevolucao") != null ? rs.getDate("dataDevolucao").toLocalDate() : null,
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }

    @Override
    public void update(Emprestimo emprestimo) {
        String sql = "UPDATE Emprestimo SET livro_id = ?, usuario_id = ?, dataEmprestimo = ?, dataDevolucao = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, emprestimo.getEmprestimoLivro());
            pstmt.setInt(2, emprestimo.getEmprestimoUsuario());
            pstmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            pstmt.setDate(4, emprestimo.getDataDevolucao() != null ? Date.valueOf(emprestimo.getDataDevolucao()) : null);
            pstmt.setString(5, emprestimo.getEmprestimoStatus());
            pstmt.setInt(6, emprestimo.getEmprestimoId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Emprestimo WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateLivroStatus(int livroId, String status) {
        String sql = "UPDATE Livro SET status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, livroId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
