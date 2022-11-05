package com.gabbo;

import java.util.Scanner;

public class ContoCorrente {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String choice;
        Correntista correntista = new Correntista();

        while (true) {
            System.out.println("""
                    Inserisci un'opzione:
                    [0] Registrazione
                    [1] Login
                    [2] Informazioni
                            """);
            choice = kb.next();

            switch (choice) {
                case "0":
                    correntista.register();
                    break;
                case "1":
                    correntista.login();
                    break;
                case "2":
                    System.out.println("""
                            Copyright (c) Mancini Gabriele
                            """);
                    break;
                default:
                    System.out.println("Opzione non valida");
            }
        }

    }
}
