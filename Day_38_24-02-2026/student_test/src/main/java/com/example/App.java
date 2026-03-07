package com.example;

// Day 38 – Maven Setup and JUnit Testing
// Run `mvn test` to execute all tests in StudentTest.java
public class App {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Alice", 20, 85.0);
        Student s2 = new Student(2, "Bob", 22, 45.0);
        Student s3 = new Student(3, "Charlie", 19, 92.0);

        System.out.println(s1 + " | Passing: " + s1.isPassing() + " | Grade: " + s1.getGradeLetter());
        System.out.println(s2 + " | Passing: " + s2.isPassing() + " | Grade: " + s2.getGradeLetter());
        System.out.println(s3 + " | Passing: " + s3.isPassing() + " | Grade: " + s3.getGradeLetter());
    }
}
