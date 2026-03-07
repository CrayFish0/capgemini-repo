package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Day 41 – Data Access Object (DAO)
// A DAO encapsulates all database operations for a specific entity.
// It keeps SQL logic out of business/service code and works with DTOs as data carriers.
public class TaskDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jpa_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "system";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ── DDL ───────────────────────────────────────────────────────────────────

    /** Creates the tasks table if it does not already exist. */
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks ("
                + "id          INT AUTO_INCREMENT PRIMARY KEY, "
                + "title       VARCHAR(200) NOT NULL, "
                + "description TEXT, "
                + "status      VARCHAR(50) DEFAULT 'TODO', "
                + "assigned_to VARCHAR(100))";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'tasks' ready.");
        } catch (SQLException e) {
            System.err.println("createTable error: " + e.getMessage());
        }
    }

    // ── Create ────────────────────────────────────────────────────────────────

    /** Persists a TaskDTO and sets the generated id back on the object. */
    public void insert(TaskDTO task) {
        String sql = "INSERT INTO tasks (title, description, status, assigned_to) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setString(4, task.getAssignedTo());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    task.setId(keys.getInt(1));
                    System.out.println("Inserted: " + task);
                }
            }
        } catch (SQLException e) {
            System.err.println("insert error: " + e.getMessage());
        }
    }

    // ── Read ──────────────────────────────────────────────────────────────────

    /** Returns all tasks as a list of TaskDTO objects. */
    public List<TaskDTO> getAll() {
        List<TaskDTO> list = new ArrayList<>();
        String sql = "SELECT id, title, description, status, assigned_to FROM tasks";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("getAll error: " + e.getMessage());
        }
        return list;
    }

    /** Returns a single TaskDTO by primary key; null if not found. */
    public TaskDTO getById(int id) {
        String sql = "SELECT id, title, description, status, assigned_to FROM tasks WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("getById error: " + e.getMessage());
        }
        return null;
    }

    /** Returns all tasks with the given status value. */
    public List<TaskDTO> getByStatus(String status) {
        List<TaskDTO> list = new ArrayList<>();
        String sql = "SELECT id, title, description, status, assigned_to FROM tasks WHERE status = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("getByStatus error: " + e.getMessage());
        }
        return list;
    }

    // ── Update ────────────────────────────────────────────────────────────────

    /** Updates every field of the task identified by its id. */
    public void update(TaskDTO task) {
        String sql = "UPDATE tasks SET title = ?, description = ?, status = ?, assigned_to = ? WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setString(4, task.getAssignedTo());
            ps.setInt(5, task.getId());
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s): " + task);
        } catch (SQLException e) {
            System.err.println("update error: " + e.getMessage());
        }
    }

    // ── Delete ────────────────────────────────────────────────────────────────

    /** Deletes the task with the given id. */
    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " row(s) for id=" + id);
        } catch (SQLException e) {
            System.err.println("delete error: " + e.getMessage());
        }
    }

    // ── Helper ────────────────────────────────────────────────────────────────

    private TaskDTO mapRow(ResultSet rs) throws SQLException {
        return new TaskDTO(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getString("assigned_to"));
    }
}
