package com.example;

import java.util.List;

// Day 40 – JDBC MySQL Connection and CRUD Demo
// Prerequisite: ensure database 'jpa_demo' exists in MySQL.
// Run: CREATE DATABASE IF NOT EXISTS jpa_demo;
public class App {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // 1. Create table
        dao.createTable();

        // 2. Insert records
        System.out.println("\n--- INSERT ---");
        dao.insert(new Student("Alice", 20, "alice@example.com"));
        dao.insert(new Student("Bob", 22, "bob@example.com"));
        dao.insert(new Student("Charlie", 19, "charlie@example.com"));

        // 3. Retrieve all
        System.out.println("\n--- SELECT ALL ---");
        List<Student> students = dao.getAll();
        students.forEach(System.out::println);

        // 4. Retrieve by ID
        System.out.println("\n--- SELECT BY ID (1) ---");
        Student s = dao.getById(1);
        System.out.println(s);

        // 5. Update
        System.out.println("\n--- UPDATE ---");
        if (s != null) {
            s.setAge(21);
            s.setEmail("alice.updated@example.com");
            dao.update(s);
        }

        // 6. Delete
        System.out.println("\n--- DELETE (id=2) ---");
        dao.delete(2);

        // 7. Final list
        System.out.println("\n--- FINAL SELECT ALL ---");
        dao.getAll().forEach(System.out::println);
    }
}
