// Day 11 – Interfaces
// An interface is a contract – defines what a class MUST do (not how).
// A class can implement multiple interfaces.

public class Interfaces {

    // Interface – all methods are public abstract by default (Java 8+:
    // default/static allowed)
    interface Printable {
        void print();
    }

    interface Serializable {
        String serialize();
    }

    // Default method (Java 8+)
    interface Loggable {
        default void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    // Implementing multiple interfaces
    static class Document implements Printable, Serializable, Loggable {
        String title, content;

        Document(String title, String content) {
            this.title = title;
            this.content = content;
        }

        @Override
        public void print() {
            System.out.println("Document: " + title + "\n" + content);
        }

        @Override
        public String serialize() {
            return "{\"title\":\"" + title + "\",\"content\":\"" + content + "\"}";
        }
    }

    // Interface extending interface
    interface Animal {
        void breathe();
    }

    interface Pet extends Animal {
        void play();
    }

    static class Dog implements Pet {
        @Override
        public void breathe() {
            System.out.println("Dog breathes.");
        }

        @Override
        public void play() {
            System.out.println("Dog plays fetch!");
        }
    }

    // Functional interface (single abstract method – used with lambdas)
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        Document doc = new Document("Java Guide", "Learn Java step by step.");
        doc.print();
        doc.log("Document printed.");
        System.out.println("Serialized: " + doc.serialize());

        Dog dog = new Dog();
        dog.breathe();
        dog.play();

        // Functional interface with lambda
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        System.out.println("\nLambda add(3,4)      = " + add.operate(3, 4));
        System.out.println("Lambda multiply(3,4) = " + multiply.operate(3, 4));
    }
}
