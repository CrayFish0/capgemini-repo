package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Day 44 – Hibernate Entity and Annotation-Based Table Mapping
//
// @Entity    – marks this class as a JPA-managed entity
// @Table     – maps the class to the 'students' database table
// @Id        – designates the primary key field
// @GeneratedValue – auto-increment strategy (IDENTITY uses DB auto_increment)
// @Column    – customises the column name, nullability, and length
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "grade")
    private double grade;

    // ── Constructors ───────────────────────────────────────────────────────────

    // JPA requires a no-arg constructor
    public Student() {
    }

    public Student(String name, int age, String email, double grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.grade = grade;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // ── Derived helpers ───────────────────────────────────────────────────────

    public boolean isPassing() {
        return grade >= 50.0;
    }

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
        return "Student{id=" + id
                + ", name='" + name + "'"
                + ", age=" + age
                + ", email='" + email + "'"
                + ", grade=" + grade
                + ", letter=" + getGradeLetter() + "}";
    }
}
