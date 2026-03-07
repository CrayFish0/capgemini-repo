package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

// Day 44 – Hibernate Entity and Relationship Mapping Demo
// Demonstrates: persist, find, update (merge), remove, and JPQL query.
// Prerequisite: database 'jpa_demo' must exist in MySQL.
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentHibernatePU");
        EntityManager em = emf.createEntityManager();

        // ── 1. Persist (INSERT) ──────────────────────────────────────────────
        em.getTransaction().begin();

        Student s1 = new Student("Alice", 20, "alice@example.com", 88.5);
        Student s2 = new Student("Bob", 22, "bob@example.com", 72.0);
        Student s3 = new Student("Charlie", 19, "charlie@example.com", 45.0);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        em.getTransaction().commit();
        System.out.println("Saved: " + s1 + ", " + s2 + ", " + s3);

        // ── 2. Find by primary key (SELECT by id) ────────────────────────────
        System.out.println("\n--- FIND by id=" + s1.getId() + " ---");
        Student found = em.find(Student.class, s1.getId());
        System.out.println(found);

        // ── 3. Update (merge) ────────────────────────────────────────────────
        System.out.println("\n--- UPDATE (set grade to 95) ---");
        em.getTransaction().begin();
        found.setGrade(95.0);
        em.merge(found);
        em.getTransaction().commit();
        System.out.println("Updated: " + em.find(Student.class, s1.getId()));

        // ── 4. JPQL query (SELECT all passing students) ─────────────────────
        System.out.println("\n--- JPQL: Students with grade >= 50 ---");
        List<Student> passing = em.createQuery(
                "SELECT s FROM Student s WHERE s.grade >= 50 ORDER BY s.grade DESC",
                Student.class).getResultList();
        passing.forEach(System.out::println);

        // ── 5. Remove (DELETE) ───────────────────────────────────────────────
        System.out.println("\n--- DELETE Charlie ---");
        em.getTransaction().begin();
        Student toDelete = em.find(Student.class, s3.getId());
        if (toDelete != null) {
            em.remove(toDelete);
        }
        em.getTransaction().commit();

        // ── 6. Final list ────────────────────────────────────────────────────
        System.out.println("\n--- FINAL All Students ---");
        em.createQuery("FROM Student", Student.class)
                .getResultList()
                .forEach(System.out::println);

        em.close();
        emf.close();
    }
}
