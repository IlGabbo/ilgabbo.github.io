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
            Enter an option:
                [0] Add a new student
                [1] Print class
                [2] Search student by first and last name
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
                        System.out.println("Enter name");
                        name = kb.next();
                        System.out.println("Enter last name");
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

        System.out.println("Enter name");
        name = kb.next();
        System.out.println("Enter last name");
        lastName = kb.next();
        System.out.println("Enter age");
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
