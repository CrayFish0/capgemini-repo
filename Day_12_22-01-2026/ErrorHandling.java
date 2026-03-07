// Day 12 – Multiple Error Handling Patterns
// try-with-resources, re-throwing, chained exceptions, exception propagation

import java.io.*;

public class ErrorHandling {

    // 1. Exception propagation – exception bubbles up the call stack
    static void level3() throws Exception {
        throw new Exception("Error in level3");
    }

    static void level2() throws Exception {
        level3();
    }

    static void level1() {
        try {
            level2();
        } catch (Exception e) {
            System.out.println("Caught at level1: " + e.getMessage());
        }
    }

    // 2. Re-throwing exception
    static void process(String input) throws IllegalArgumentException {
        try {
            int val = Integer.parseInt(input);
            if (val < 0)
                throw new IllegalArgumentException("Negative value: " + val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a number: " + input, e);
        }
    }

    // 3. Chained exceptions
    static void readFile(String path) throws IOException {
        try {
            throw new FileNotFoundException("File not found: " + path);
        } catch (FileNotFoundException e) {
            throw new IOException("Failed to read file", e); // wraps original cause
        }
    }

    public static void main(String[] args) {
        // Propagation
        System.out.println("=== Exception Propagation ===");
        level1();

        // Re-throwing
        System.out.println("\n=== Re-throwing ===");
        try {
            process("abc");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Caused by: " + e.getCause().getClass().getSimpleName());
        }

        // Chained
        System.out.println("\n=== Chained Exception ===");
        try {
            readFile("data.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
        }

        // 4. try-with-resources (auto-closes Closeable objects)
        System.out.println("\n=== try-with-resources ===");
        try (StringReader sr = new StringReader("Sample text")) {
            char[] buf = new char[11];
            sr.read(buf);
            System.out.println("Read: " + new String(buf));
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
        // sr is automatically closed here

        // 5. finally vs return
        System.out.println("\n=== finally vs return ===");
        System.out.println("Result: " + finallyDemo());
    }

    static String finallyDemo() {
        try {
            return "try block";
        } finally {
            System.out.println("finally runs before return!");
        }
    }
}
