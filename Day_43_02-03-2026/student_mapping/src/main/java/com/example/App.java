package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

// Day 43 – Hibernate Many-to-Many Mapping Demo
// Hibernate auto-creates: students, courses, and student_course (join table).
// Prerequisite: database 'jpa_demo' must exist in MySQL.
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentMappingPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // 1. Create courses
        Course java = new Course("Java Programming", "CS101");
        Course python = new Course("Python for Data", "DS201");
        Course db = new Course("Database Systems", "DB301");

        // 2. Create students
        Student alice = new Student("Alice", 20);
        Student bob = new Student("Bob", 22);
        Student charlie = new Student("Charlie", 19);

        // 3. Assign courses to students (many-to-many)
        alice.addCourse(java);
        alice.addCourse(db);

        bob.addCourse(java);
        bob.addCourse(python);

        charlie.addCourse(python);
        charlie.addCourse(db);

        // 4. Persist students (courses cascade via PERSIST)
        em.persist(alice);
        em.persist(bob);
        em.persist(charlie);

        em.getTransaction().commit();
        System.out.println("Saved students and courses.");

        // 5. Read back and display
        System.out.println("\n--- All Students and their Courses ---");
        List<Student> students = em.createQuery("FROM Student", Student.class).getResultList();
        for (Student s : students) {
            System.out.println(s);
            for (Course c : s.getCourses()) {
                System.out.println("   -> " + c);
            }
        }

        em.close();
        emf.close();
    }
}
