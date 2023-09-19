package com.gabbo.overriding;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner k = new Scanner(System.in);

        while (true) {
            System.out.println("""
            [0] Dog
            [1] Cat
            [2] Exit
                    """);
            choice = k.nextInt();

            switch (choice) {
                case 0 -> {
                    Dog dog = new Dog();
                    dog.verse();
                }
                case 1 -> {
                    Cat cat = new Cat();
                    cat.verse();
                }
                case 2 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Wrong choice");
                }
            }

        }
    }
}
