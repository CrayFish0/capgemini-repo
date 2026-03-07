// Day 9 – Inheritance (Advanced): Types of Inheritance in Java
// Java supports: Single, Multilevel, Hierarchical inheritance.
// Multiple inheritance (via classes) is NOT allowed; use interfaces instead.

public class InheritanceAdvanced {

    // ===== 1. Single Inheritance =====
    static class Shape {
        double area() {
            return 0;
        }

        void display() {
            System.out.println("Shape area: " + area());
        }
    }

    static class Circle extends Shape {
        double radius;

        Circle(double r) {
            this.radius = r;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    // ===== 2. Multilevel Inheritance =====
    // A -> B -> C
    static class Vehicle {
        void start() {
            System.out.println("Vehicle started.");
        }
    }

    static class Car extends Vehicle {
        void drive() {
            System.out.println("Car is driving.");
        }
    }

    static class ElectricCar extends Car {
        void charge() {
            System.out.println("Electric car is charging.");
        }
    }

    // ===== 3. Hierarchical Inheritance =====
    // One parent, multiple children
    static class Fruit {
        String name;

        Fruit(String name) {
            this.name = name;
        }

        void taste() {
            System.out.println(name + " has a taste.");
        }
    }

    static class Mango extends Fruit {
        Mango() {
            super("Mango");
        }

        @Override
        void taste() {
            System.out.println("Mango is sweet!");
        }
    }

    static class Lemon extends Fruit {
        Lemon() {
            super("Lemon");
        }

        @Override
        void taste() {
            System.out.println("Lemon is sour!");
        }
    }

    // ===== 4. Multiple Inheritance via Interfaces =====
    interface Flyable {
        default void fly() {
            System.out.println("Flying!");
        }
    }

    interface Swimmable {
        default void swim() {
            System.out.println("Swimming!");
        }
    }

    static class Duck extends Animal implements Flyable, Swimmable {
        Duck(String name) {
            super(name, 2);
        }
    }

    static class Animal {
        String name;
        int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void sound() {
            System.out.println(name + " makes a sound.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Single Inheritance ===");
        Circle c = new Circle(5);
        c.display();

        System.out.println("\n=== Multilevel Inheritance ===");
        ElectricCar ec = new ElectricCar();
        ec.start();
        ec.drive();
        ec.charge();

        System.out.println("\n=== Hierarchical Inheritance ===");
        Mango m = new Mango();
        m.taste();
        Lemon l = new Lemon();
        l.taste();

        System.out.println("\n=== Multiple via Interface ===");
        Duck duck = new Duck("Donald");
        duck.sound();
        duck.fly();
        duck.swim();
    }
}
