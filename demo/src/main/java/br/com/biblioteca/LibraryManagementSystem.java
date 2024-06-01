package br.com.biblioteca;

import java.util.Scanner;
import java.util.List;

public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static LivroRepository livroRepository = new LivroRepository();
    private static UsuarioRepository usuarioRepository = new UsuarioRepository();
    private static EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    private static void cadastrarLivro() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Digite a categoria do livro (FICCAO, NAO_FICCAO, CIENCIA, HISTORIA, TECNOLOGIA, OUTROS):");
        String categoriaStr = scanner.nextLine();
        Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());
        Livro livro = new Livro(titulo, autor, categoria);
        livroRepository.save(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone do usuário:");
        String telefone = scanner.nextLine();
        Usuario usuario = new Usuario(nome, email, telefone);
        usuarioRepository.save(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void realizarEmprestimo() {
        System.out.println("Digite o ID do livro:");
        int livroId = scanner.nextInt();
        System.out.println("Digite o ID do usuário:");
        int usuarioId = scanner.nextInt();
        Emprestimo emprestimo = new Emprestimo(livroId, usuarioId);
        emprestimoRepository.save(emprestimo);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    private static void devolverLivro() {
        System.out.println("Digite o ID do empréstimo:");
        int emprestimoId = scanner.nextInt();
        emprestimoRepository.devolverLivro(emprestimoId);
        System.out.println("Livro devolvido com sucesso!");
    }
}

