// Day 5 – Constructors: Default, Parameterized, Non-Parameterized
// A constructor initializes an object when it is created.

public class Constructors {

    static class Student {
        String name;
        int age;
        double gpa;

        // 1. Default constructor (no parameters, no body except defaults)
        Student() {
            this.name = "Unknown";
            this.age = 0;
            this.gpa = 0.0;
        }

        // 2. Non-parameterized constructor with logic
        // (same as default in this example; sometimes used for setup)
        // The compiler provides one if no constructor is written.

        // 3. Parameterized constructor
        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        // 4. Constructor chaining with this()
        Student(String name) {
            this(name, 18, 0.0); // calls parameterized constructor
        }

        void display() {
            System.out.printf("Name: %-15s  Age: %d  GPA: %.2f%n", name, age, gpa);
        }
    }

    // Copy constructor pattern
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Copy constructor
        Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(); // default
        Student s2 = new Student("Alice", 20, 9.1); // parameterized
        Student s3 = new Student("Bob"); // partial parameterized

        s1.display();
        s2.display();
        s3.display();

        Point p1 = new Point(3, 4);
        Point p2 = new Point(p1); // copy
        p2.x = 10; // does NOT affect p1
        System.out.println("p1: " + p1 + "  p2: " + p2);
    }
}
