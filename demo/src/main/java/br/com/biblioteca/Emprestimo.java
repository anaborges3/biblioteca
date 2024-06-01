package br.com.biblioteca;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int livroId;
    private int usuarioId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;

    public Emprestimo(int livroId, int usuarioId) {
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataEmprestimo = LocalDate.now();
        this.status = "EMPRESTADO";
    }

    public Emprestimo(int id, int livroId, int usuarioId, LocalDate dataEmprestimo, LocalDate dataDevolucao, String status) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    // Getters and Setters
    public int getEmprestimoId() {
        return id;
    }

    public void setEmprestimoId(int id) {
        this.id = id;
    }

    public int getEmprestimoLivro() {
        return livroId;
    }

    public void setEmprestimoLivro(Livro livro) {
        this.livroId = livroId;
    }

    public int getEmprestimoUsuario() {
        return usuarioId;
    }

    public void setEmprestimoUsuario(Usuario usuario) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getEmprestimoStatus() {
        return status;
    }

    public void setEmprestimoStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livroId +
                ", usuario=" + usuarioId +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", status='" + status + '\'' +
                '}';
    }
}

