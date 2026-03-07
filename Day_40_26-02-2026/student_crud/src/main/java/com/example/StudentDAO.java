package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Day 40 – Data Access Object for JDBC CRUD operations on the 'students' table
public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jpa_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "system";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ── DDL ───────────────────────────────────────────────────────────────────

    /** Creates the students table if it does not already exist. */
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id    INT AUTO_INCREMENT PRIMARY KEY, "
                + "name  VARCHAR(100) NOT NULL, "
                + "age   INT, "
                + "email VARCHAR(150))";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'students' ready.");
        } catch (SQLException e) {
            System.err.println("createTable error: " + e.getMessage());
        }
    }

    // ── Create ────────────────────────────────────────────────────────────────

    /** Inserts a new student record and prints the generated ID. */
    public void insert(Student student) {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    System.out.println("Inserted: " + student.getName() + " (id=" + keys.getInt(1) + ")");
                }
            }
        } catch (SQLException e) {
            System.err.println("insert error: " + e.getMessage());
        }
    }

    // ── Read ──────────────────────────────────────────────────────────────────

    /** Retrieves all student records from the table. */
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, age, email FROM students";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println("getAll error: " + e.getMessage());
        }
        return list;
    }

    /** Retrieves a single student by primary key; returns null if not found. */
    public Student getById(int id) {
        String sql = "SELECT id, name, age, email FROM students WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.err.println("getById error: " + e.getMessage());
        }
        return null;
    }

    // ── Update ────────────────────────────────────────────────────────────────

    /** Updates an existing student record identified by id. */
    public void update(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getId());
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s) for id=" + student.getId());
        } catch (SQLException e) {
            System.err.println("update error: " + e.getMessage());
        }
    }

    // ── Delete ────────────────────────────────────────────────────────────────

    /** Deletes the student with the given id. */
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " row(s) for id=" + id);
        } catch (SQLException e) {
            System.err.println("delete error: " + e.getMessage());
        }
    }
}
