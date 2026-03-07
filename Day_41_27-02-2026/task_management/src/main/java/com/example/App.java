package com.example;

import java.util.List;

// Day 41 – DAO + DTO Pattern Demo
// TaskDTO  → carries data between layers (no SQL).
// TaskDAO  → handles all SQL operations, accepts/returns TaskDTO objects.
public class App {

    public static void main(String[] args) {
        TaskDAO dao = new TaskDAO();

        // 1. Create table
        dao.createTable();

        // 2. Insert tasks
        System.out.println("\n--- INSERT ---");
        TaskDTO t1 = new TaskDTO("Design DB schema", "Create ER diagram", "DONE", "Alice");
        TaskDTO t2 = new TaskDTO("Implement CRUD", "Write DAO and DTO classes", "IN_PROGRESS", "Bob");
        TaskDTO t3 = new TaskDTO("Write unit tests", "Cover all DAO methods", "TODO", "Charlie");
        TaskDTO t4 = new TaskDTO("Deploy to server", "Package and deploy WAR file", "TODO", "Alice");
        dao.insert(t1);
        dao.insert(t2);
        dao.insert(t3);
        dao.insert(t4);

        // 3. Retrieve all
        System.out.println("\n--- SELECT ALL ---");
        dao.getAll().forEach(System.out::println);

        // 4. Retrieve by ID
        System.out.println("\n--- SELECT BY ID (1) ---");
        System.out.println(dao.getById(t1.getId()));

        // 5. Filter by status
        System.out.println("\n--- SELECT BY STATUS = 'TODO' ---");
        List<TaskDTO> todoTasks = dao.getByStatus("TODO");
        todoTasks.forEach(System.out::println);

        // 6. Update
        System.out.println("\n--- UPDATE (mark t3 as IN_PROGRESS) ---");
        t3.setStatus("IN_PROGRESS");
        dao.update(t3);

        // 7. Delete
        System.out.println("\n--- DELETE (t4) ---");
        dao.delete(t4.getId());

        // 8. Final list
        System.out.println("\n--- FINAL SELECT ALL ---");
        dao.getAll().forEach(System.out::println);
    }
}
