package com.example;

// Day 38 – Student POJO used for JUnit testing
public class Student {

    private int id;
    private String name;
    private int age;
    private double grade;

    public Student() {
    }

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // ── Getters & Setters ──────────────────────────────────────────────────────

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // ── Business Logic ─────────────────────────────────────────────────────────

    /** Returns true if the student's grade is 50 or above. */
    public boolean isPassing() {
        return grade >= 50.0;
    }

    /**
     * Maps a numeric grade to a letter grade.
     * A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
     */
    public String getGradeLetter() {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }
}
