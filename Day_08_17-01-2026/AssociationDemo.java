// Day 8 – Association, Aggregation, and Composition

// Association – a general "uses-a" relationship between two classes.
// Aggregation – "has-a" with independent lifecycle (weak ownership).
// Composition  – "has-a" with dependent lifecycle (strong ownership).

public class AssociationDemo {

    // ===== Association =====
    // Teacher teaches Student – no ownership, both exist independently.
    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Teacher {
        String name;

        Teacher(String name) {
            this.name = name;
        }

        void teach(Student s) {
            System.out.println(this.name + " is teaching " + s.name);
        }
    }

    // ===== Aggregation (weak "has-a") =====
    // Department has Professors – Professors exist even without Department.
    static class Professor {
        String name;

        Professor(String name) {
            this.name = name;
        }
    }

    static class Department {
        String name;
        Professor[] professors; // department aggregates professors

        Department(String name, Professor[] professors) {
            this.name = name;
            this.professors = professors;
        }

        void list() {
            System.out.println("Department: " + name);
            for (Professor p : professors)
                System.out.println("  Prof: " + p.name);
        }
    }

    // ===== Composition (strong "has-a") =====
    // House contains Rooms – Rooms cannot exist without the House.
    static class Room {
        String type;

        Room(String type) {
            this.type = type;
        }
    }

    static class House {
        String address;
        Room[] rooms; // rooms are created and destroyed with the house

        House(String address) {
            this.address = address;
            this.rooms = new Room[] { new Room("Bedroom"), new Room("Kitchen"), new Room("Hall") };
        }

        void describe() {
            System.out.println("House at: " + address);
            for (Room r : rooms)
                System.out.println("  Room: " + r.type);
        }
    }

    public static void main(String[] args) {
        // Association
        Teacher t = new Teacher("Mr. Sharma");
        Student s = new Student("Ravi");
        t.teach(s);

        // Aggregation
        Professor[] profs = { new Professor("Dr. Patel"), new Professor("Dr. Singh") };
        Department dept = new Department("Computer Science", profs);
        dept.list();

        // Composition
        House h = new House("42 MG Road, Bengaluru");
        h.describe();
    }
}
