// Day 11 – Abstract Classes
// An abstract class cannot be instantiated; it provides a template for subclasses.
// Abstract methods have no body – subclasses MUST override them.

public class AbstractClasses {

    // Abstract class
    abstract static class Shape {
        String color;

        Shape(String color) {
            this.color = color;
        }

        // Abstract method – no implementation here
        abstract double area();

        abstract double perimeter();

        // Concrete method – shared by all subclasses
        void display() {
            System.out.printf("[%s] Area: %.2f  Perimeter: %.2f%n",
                    getClass().getSimpleName(), area(), perimeter());
        }
    }

    static class Circle extends Shape {
        double radius;

        Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        @Override
        double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Rectangle extends Shape {
        double width, height;

        Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }

        @Override
        double perimeter() {
            return 2 * (width + height);
        }
    }

    static class Triangle extends Shape {
        double a, b, c;

        Triangle(String color, double a, double b, double c) {
            super(color);
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        double perimeter() {
            return a + b + c;
        }

        @Override
        double area() {
            double s = perimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Red", 5),
                new Rectangle("Blue", 4, 6),
                new Triangle("Green", 3, 4, 5)
        };

        for (Shape s : shapes)
            s.display();
    }
}
