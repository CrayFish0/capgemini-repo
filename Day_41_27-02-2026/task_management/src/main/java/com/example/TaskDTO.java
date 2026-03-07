package com.example;

// Day 41 – Data Transfer Object (DTO)
// A DTO is a plain Java object used to carry data between layers.
// It contains only fields, constructors, getters, and setters — no business logic.
public class TaskDTO {

    private int id;
    private String title;
    private String description;
    private String status; // e.g. "TODO", "IN_PROGRESS", "DONE"
    private String assignedTo;

    public TaskDTO() {
    }

    // Constructor for creating a new task (no id yet)
    public TaskDTO(String title, String description, String status, String assignedTo) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    // Constructor used when reading from the database
    public TaskDTO(int id, String title, String description, String status, String assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "TaskDTO{id=" + id
                + ", title='" + title + "'"
                + ", status='" + status + "'"
                + ", assignedTo='" + assignedTo + "'}";
    }
}
