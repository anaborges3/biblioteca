package br.com.biblioteca;

import java.util.List;

public class BookSearch {
    public static Livro searchBook(List<Livro> livros, String titulo) {
        if (livros.isEmpty()) {
            return null;
        }
        Livro livro = livros.get(0);
        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
            return livro;
        }
        return searchBook(livros.subList(1, livros.size()), titulo);
    }
}

