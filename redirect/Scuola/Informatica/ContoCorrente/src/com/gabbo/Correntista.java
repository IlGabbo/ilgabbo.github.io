package com.gabbo;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Correntista {
    ArrayList<String> nameSaved = new  ArrayList<String>();
    ArrayList<String> lastnameSaved = new  ArrayList<String>();
    ArrayList<String> savedPins = new  ArrayList<String>();
    String nome, cognome, pin;

    int i = 0;
    int s = 0;
    float importo = 0;
    float saldo[] = new float[100];

    boolean check = false;
    boolean randomCheck = false;

    Scanner kb = new Scanner(System.in);

    public void saldo() {
        String choice;
        while (true) {
            System.out.println("""
                    [0] Prelievo
                    [1] Versamento
                    [2] Visualizza saldo
                    [3] Esci
                            """);
            choice = kb.next();

            switch (choice) {
                case "0":
                    System.out.println("Importo da prelevare:");
                    importo = kb.nextFloat();
                    saldo[s] -= importo;
                    System.out.println("Prelevati " + importo + "€");
                    break;
                case "1":
                    System.out.println("Inserisci l'importo:");
                    importo = kb.nextFloat();
                    System.out.println("Versati €" + importo);
                    saldo[s] += importo;
                    break;
                case "2":
                    System.out.println("Saldo " + saldo[s] + "€");
                    break;
                case "3":
                    randomCheck = true;
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }

            if (randomCheck == true) {
                randomCheck = false;
                break;
            }
        }
    }

    public void register() {
        i += 1;
        System.out.println("Nome:");
        nome = kb.next();
        System.out.println("Cognome:");
        cognome = kb.next();
        System.out.println("Digita un pin");
        pin = kb.next();

        for (int j = 0; j < savedPins.size(); j++) {
            if (savedPins.get(j).equals(pin)) {
                System.out.println("Pin esistente");
                check = true;
                break;
            } else {
                check = false;
                continue;
            }
        }

        if (check == true) {


        } else {
            System.out.println("Registrazione effettuata");
            savedPins.add(pin);
            nameSaved.add(nome);
            lastnameSaved.add(cognome);
            pin = "";
            /* for (int j = 0; j < savedPins.size(); j++) {
                System.out.println(nameSaved.get(j) + " " + lastnameSaved.get(j) + " " + savedPins.get(j));
            } */

        }
    }

    public void login() {
        System.out.println("Nome:");
        nome = kb.next();
        System.out.println("Cognome:");
        cognome = kb.next();
        System.out.println("Pin:");
        pin = kb.next();

        for (int j = 0; j < savedPins.size(); j++) {
            if (nome.equals(nameSaved.get(j)) && cognome.equals(lastnameSaved.get(j)) && pin.equals(savedPins.get(j))) {
                System.out.println("Login effettuato");
                check = false;
                saldo();
                break;
            } else {
                s += 1;
                check = true;
                continue;
            }
        }

        if (check == true) {
            System.out.println("Non esisti");
        }
        s = 0;
    }
}
