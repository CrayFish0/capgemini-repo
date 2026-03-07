// Day 10 – Upcasting, Downcasting, and Polymorphism

public class CastingAndPolymorphism {

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void sound() {
            System.out.println(name + " makes a generic sound.");
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void sound() {
            System.out.println(name + " says: Woof!");
        }

        void fetch() {
            System.out.println(name + " fetches the ball!");
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        void sound() {
            System.out.println(name + " says: Meow!");
        }
    }

    public static void main(String[] args) {
        // ===== Upcasting (implicit) =====
        // Child reference assigned to Parent variable
        Animal a = new Dog("Buddy"); // Dog IS-A Animal
        a.sound(); // calls Dog's sound() – runtime polymorphism
        // a.fetch(); // compile error: Animal doesn't have fetch()

        // ===== Downcasting (explicit) =====
        // Cast parent reference back to child type
        Dog d = (Dog) a; // safe because a actually points to a Dog
        d.fetch();

        // Safe downcasting using instanceof
        Animal animal2 = new Cat("Kitty");
        if (animal2 instanceof Dog) {
            ((Dog) animal2).fetch();
        } else {
            System.out.println(animal2.name + " is not a Dog – cast skipped.");
        }

        // ===== Runtime Polymorphism =====
        // Same method call behaves differently based on actual object type
        System.out.println("\n=== Polymorphism – Animal array ===");
        Animal[] animals = { new Dog("Rex"), new Cat("Luna"), new Dog("Max"), new Cat("Bella") };
        for (Animal an : animals) {
            an.sound(); // resolved at runtime
        }
    }
}
