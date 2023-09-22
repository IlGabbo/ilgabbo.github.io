package com.gabbo.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> students = new ArrayList<>();
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("""
            Type an option:
                [0] Add new student
                [1] Print class
                [2] Search student by name and lastname
                [3] Exit
                    """);

                choice = kb.nextInt();

                switch (choice) {
                    case 0:
                        newStudent();
                        break;
                    case 1:
                        for (Student student: students) {
                            System.out.println(student.name() + " " + student.lastName() + " " + student.age());
                        }
                        break;
                    case 2:
                        String name, lastName;
                        System.out.println("Type the name");
                        name = kb.next();
                        System.out.println("Type the last name");
                        lastName = kb.next();

                        if (studentFound(name, lastName)) {
                            System.out.println("[V] Student found with name " + name + " and last name " + lastName);
                        } else {
                            System.out.println("[!] Student not found");
                        }
                        break;
                    case 3:
                        System.exit(0);
                }
        } while (choice <= 4 && choice >= 0);
    }

    static void newStudent() {
        int age;
        String name, lastName;

        System.out.println("Type the name");
        name = kb.next();
        System.out.println("Type last name");
        lastName = kb.next();
        System.out.println("Type age");
        age = kb.nextInt();

        students.add(new Student(name, lastName, age));
    }

    static boolean studentFound(String name, String lastName) {
        for (Student student: students) {
            if (name.equalsIgnoreCase(student.name()) && lastName.equalsIgnoreCase(student.lastName())) {
                return true;
            }
        }
        return false;
    }
}
