package br.com.biblioteca;

import java.io.Serializable;

public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String titulo;
    private String autor;
    private Categoria categoria;
    private String status;

    public Livro(String titulo, String autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.status = "DISPONIVEL";
    }

    public Livro(int id, String titulo, String autor, Categoria categoria, String status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.status = status;
    }

    public int getLivroId() {
        return id;
    }

    public void setLivroId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria=" + categoria +
                ", status='" + status + '\'' +
                '}';
    }
}

