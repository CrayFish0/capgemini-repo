// Day 34 – Stream API, Comparator, and Threads (intro)

import java.util.*;
import java.util.stream.*;

public class StreamAPIAndThreads {

    // ===== Stream API =====
    static void streamDemo() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        System.out.println("=== Stream API ===");

        // filter + collect
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Evens  : " + evens);

        // map + collect
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared: " + squared);

        // sorted
        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted : " + sorted);

        // reduce
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum    : " + sum);

        // count, min, max
        System.out.println("Count  : " + numbers.stream().count());
        System.out.println("Min    : " + numbers.stream().min(Integer::compareTo).orElse(-1));
        System.out.println("Max    : " + numbers.stream().max(Integer::compareTo).orElse(-1));

        // distinct + limit + skip
        List<Integer> dup = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("Distinct: " + dup.stream().distinct().collect(Collectors.toList()));

        // String operations
        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        String joined = words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Joined : " + joined);

        // groupingBy
        Map<Integer, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + grouped);
    }

    // ===== Comparator =====
    static void comparatorDemo() {
        System.out.println("\n=== Comparator ===");

        record Person(String name, int age, String city) {
        }

        List<Person> people = new ArrayList<>(List.of(
                new Person("Alice", 30, "Mumbai"),
                new Person("Bob", 25, "Delhi"),
                new Person("Carol", 30, "Bengaluru"),
                new Person("Dave", 22, "Mumbai")));

        // Sort by age, then name
        people.sort(Comparator.comparingInt(Person::age).thenComparing(Person::name));
        people.forEach(p -> System.out.printf("%-10s %2d %s%n", p.name(), p.age(), p.city()));

        // Reverse order
        people.sort(Comparator.comparingInt(Person::age).reversed());
        System.out.println("Oldest first: " + people.stream().map(Person::name).collect(Collectors.toList()));
    }

    // ===== Threads (intro) =====
    static void threadDemo() throws InterruptedException {
        System.out.println("\n=== Threads ===");

        // Method 1: extend Thread
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++)
                    System.out.println("Thread-1 count: " + i);
            }
        };

        // Method 2: implement Runnable (preferred)
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("Thread-2 count: " + i);
        };
        Thread t2 = new Thread(task, "WorkerThread");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both threads finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        streamDemo();
        comparatorDemo();
        threadDemo();
    }
}
