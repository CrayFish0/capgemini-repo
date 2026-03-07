// Day 4 – Objects, Classes, Methods (concept overview)

public class ObjectsAndClasses {

    // A class is a blueprint; an object is an instance of that blueprint.

    static class Car {
        // Fields (attributes / state)
        String brand;
        String model;
        int year;

        // Constructor
        Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        // Method (behaviour)
        void display() {
            System.out.println(year + " " + brand + " " + model);
        }

        int age() {
            return 2026 - year;
        }
    }

    static class Counter {
        // Instance variable
        private int count = 0;

        void increment() {
            count++;
        }

        void decrement() {
            count--;
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Creating objects (instances)
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2018);

        car1.display();
        car2.display();
        System.out.println("car1 age: " + car1.age() + " years");

        // Each object maintains its own state
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increment();
        c1.increment();
        c1.increment();
        c2.increment();
        System.out.println("c1 count: " + c1.getCount()); // 3
        System.out.println("c2 count: " + c2.getCount()); // 1
    }
}
