package br.com.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    private static Scanner scanner = new Scanner(System.in);

    public static int handleInputMismatchException() {
        while (true) {
            try {
                System.out.print("Por favor, insira um número: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Por favor, insira um número.");
                scanner.next(); // clear the invalid input
            }
        }
    }
}

