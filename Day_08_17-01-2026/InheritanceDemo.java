// Day 8 – Inheritance
// Inheritance allows one class to acquire properties and methods of another.
// Syntax: class Child extends Parent

public class InheritanceDemo {

    // Base / Parent class
    static class Animal {
        String name;
        int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void eat() {
            System.out.println(name + " is eating.");
        }

        void sleep() {
            System.out.println(name + " is sleeping.");
        }

        @Override
        public String toString() {
            return "Animal{name='" + name + "', age=" + age + "}";
        }
    }

    // Child class – inherits Animal, adds its own behaviour
    static class Dog extends Animal {
        String breed;

        Dog(String name, int age, String breed) {
            super(name, age); // calls Animal constructor
            this.breed = breed;
        }

        void bark() {
            System.out.println(name + " says: Woof!");
        }

        // Method overriding
        @Override
        public void eat() {
            System.out.println(name + " (Dog) is eating kibble.");
        }

        @Override
        public String toString() {
            return "Dog{name='" + name + "', breed='" + breed + "'}";
        }
    }

    // Another child class
    static class Cat extends Animal {
        Cat(String name, int age) {
            super(name, age);
        }

        void purr() {
            System.out.println(name + " says: Purr...");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog("Buddy", 3, "Labrador");
        d.eat(); // overridden method
        d.sleep(); // inherited from Animal
        d.bark(); // Dog-specific
        System.out.println(d);

        Cat c = new Cat("Whiskers", 2);
        c.eat(); // inherited, not overridden
        c.purr();

        // instanceof check
        System.out.println("\nd instanceof Animal : " + (d instanceof Animal));
        System.out.println("c instanceof Dog    : " + (c instanceof Dog));
    }
}
