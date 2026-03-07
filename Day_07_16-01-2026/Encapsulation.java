// Day 7 – Encapsulation
// Wrapping data (fields) and behaviour (methods) into a class,
// hiding internal details and exposing only what is needed.

public class Encapsulation {

    static class Employee {
        // Private fields – cannot be accessed directly from outside
        private int id;
        private String name;
        private double salary;

        // Constructor
        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            setSalary(salary); // use setter for validation
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        // Setters with validation
        public void setName(String name) {
            if (name != null && !name.isBlank())
                this.name = name;
        }

        public void setSalary(double salary) {
            if (salary >= 0)
                this.salary = salary;
            else
                System.out.println("Invalid salary – must be non-negative.");
        }

        public void applyRaise(double percent) {
            if (percent > 0)
                salary += salary * percent / 100;
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee(101, "Alice", 50000.0);
        System.out.println(e);

        e.setSalary(-1000); // validation triggers
        e.applyRaise(10); // 10% raise
        System.out.println("After raise: " + e);

        e.setName("Alice Smith");
        System.out.println("Name updated: " + e.getName());
    }
}
