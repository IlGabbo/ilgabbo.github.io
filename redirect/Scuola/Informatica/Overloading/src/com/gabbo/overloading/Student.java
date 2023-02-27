package com.gabbo.overloading;

public class Student extends Person {
    private String school, course, classroom;

    public String getSchool() {
        return school;
    }

    public String getCourse() {
        return course;
    }

    public String getClassroom() {
        return classroom;
    }

    public Student(String name, String surname, int age, String school, String course, String classroom) {
        super(name, surname, age);
        this.school = school;
        this.course = course;
        this.classroom = classroom;
    }
}
