package com.example.lvandrvproject;

import java.util.ArrayList;

public class Teacher {
    String name;
    String course;

    public Teacher(String name, String course){
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList<Teacher> get10RandomTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Pooja","Android"));
        teachers.add(new Teacher("Madhu","NodeJS"));
        teachers.add(new Teacher("Rachna","Electronics"));
        teachers.add(new Teacher("Umme","Philosophy"));
        teachers.add(new Teacher("Subiya","Medicine"));
        teachers.add(new Teacher("Yogita","Interior Designing"));
        teachers.add(new Teacher("Neha","Business"));
        teachers.add(new Teacher("Meena","Psychology"));
        teachers.add(new Teacher("Anjana","Finance"));
        teachers.add(new Teacher("Renu","Human Resources"));

        return teachers;
    }
}
