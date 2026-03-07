// Day 33 – Generic Classes and Lambda Expressions

import java.util.*;
import java.util.function.*;

public class GenericsAndLambda {

    // ===== Generic Class =====
    static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    // Generic method
    static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Generic stack
    static class GenericStack<T> {
        private final List<T> data = new ArrayList<>();

        void push(T item) {
            data.add(item);
        }

        T pop() {
            return data.remove(data.size() - 1);
        }

        T peek() {
            return data.get(data.size() - 1);
        }

        boolean isEmpty() {
            return data.isEmpty();
        }

        int size() {
            return data.size();
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Bounded type parameter
    static <T extends Number> double sum(List<T> list) {
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        // Generic class usage
        Pair<String, Integer> p1 = new Pair<>("Alice", 90);
        Pair<Double, Double> p2 = new Pair<>(3.14, 2.71);
        System.out.println("Pair p1: " + p1);
        System.out.println("Pair p2: " + p2);

        System.out.println("max(10, 20)     = " + max(10, 20));
        System.out.println("max(\"apple\",\"mango\") = " + max("apple", "mango"));

        GenericStack<String> gs = new GenericStack<>();
        gs.push("Java");
        gs.push("Python");
        gs.push("C++");
        System.out.println("Stack: " + gs + "  peek: " + gs.peek());
        gs.pop();
        System.out.println("After pop: " + gs);

        System.out.println("Sum of [1.5,2.5,3.0] = " + sum(Arrays.asList(1.5, 2.5, 3.0)));

        // ===== Lambda Expressions =====
        System.out.println("\n=== Lambda Expressions ===");

        // Runnable
        Runnable r = () -> System.out.println("Lambda Runnable running!");
        r.run();

        // Comparator
        List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "Diana"));
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);

        // Function<T, R>
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("square(7) = " + square.apply(7));

        // BiFunction
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("add(3, 4) = " + add.apply(3, 4));

        // Predicate
        Predicate<String> isLong = s -> s.length() > 4;
        System.out.println("isLong(\"Hi\")     = " + isLong.test("Hi"));
        System.out.println("isLong(\"Hello\")  = " + isLong.test("Hello"));

        // Consumer
        Consumer<String> printer = s -> System.out.println(">> " + s);
        names.forEach(printer);

        // Supplier
        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> newList = listFactory.get();
        newList.add("item1");
        System.out.println("Supplier: " + newList);

        // Method reference
        names.forEach(System.out::println);
    }
}
