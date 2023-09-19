package com.gabbo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        ArrayList<Person> person = new ArrayList<>();
        Random random = new Random();
        float salary[] = new float[3];
        person.add(new Employee("DarkSnake", "Py", 18, "01/02/2023", 2000, "Software Developer"));
        person.add(new Employee("Obama", "Gaming", 18, "12/12/2020", 3500, "C# Developer"));
        person.add(new Employee("Red", "Luke", 19, "20/05/2019", 1000, "Gaming Developer"));

        for (int i = 0; i < person.size(); i++) {
            salary[i] = person.get(i).getSalary();
        }
        Arrays.sort(salary);
        for (int i = 0; i < salary.length; i++) {
            System.out.println(salary[i]);
        }

        int rnd = random.nextInt(0, 2);
        if (person.get(rnd).isTheSalaryBigger(1000)) {
            System.out.println(person.get(rnd).getName());
            System.out.println(true);
        } else {
            System.out.println(person.get(rnd).getName());
            System.out.println(false);
        }
    }
}

class Person {
    String name, last_name, recruitment_date, work;
    int age;
    float salary;
    public Person(String name, String last_name, int age, String recruitment_date, float salary, String work) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.recruitment_date = recruitment_date;
        this.salary = salary;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public String getRecruitmentDate() {
        return recruitment_date;
    }

    public float getSalary() {
        return salary;
    }

    public String getWork() {
        return work;
    }

    public boolean isTheSalaryBigger(float new_salary) {
        float old_salary = salary;
        salary = new_salary;
        if (old_salary > new_salary) {
            return false;
        } else {
            return true;
        }
    }
}

class Employee extends Person {
    public Employee(String name, String last_name, int age, String recruitment_date, float salary, String work) {
        super(name, last_name, age, recruitment_date, salary, work);
    }
}
