// Day 35 – Threads (continued), Synchronization, File Handling

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsFileHandling {

    // ===== Thread Lifecycle States =====
    // NEW -> RUNNABLE -> RUNNING -> BLOCKED/WAITING/TIMED_WAITING -> TERMINATED

    // ===== Shared Counter WITHOUT synchronization (race condition demo) =====
    static int unsafeCount = 0;

    // ===== Shared Counter WITH synchronized =====
    static int safeCount = 0;

    static synchronized void incrementSafe() {
        safeCount++;
    }

    // ===== ReentrantLock =====
    static final ReentrantLock lock = new ReentrantLock();
    static int lockCount = 0;

    static void incrementWithLock() {
        lock.lock();
        try {
            lockCount++;
        } finally {
            lock.unlock();
        }
    }

    static void synchronizationDemo() throws InterruptedException {
        // Safe counter with 10 threads each incrementing 1000 times
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    incrementSafe();
            });
            threads[i].start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("Safe count (expected 10000)   : " + safeCount);

        // Lock demo
        Thread[] lThreads = new Thread[10];
        for (int i = 0; i < lThreads.length; i++) {
            lThreads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    incrementWithLock();
            });
            lThreads[i].start();
        }
        for (Thread t : lThreads)
            t.join();
        System.out.println("Lock count  (expected 10000)  : " + lockCount);
    }

    // ===== File Handling =====
    static void fileHandlingDemo() throws IOException {
        String filePath = "test_output.txt";

        // Write to file (FileWriter)
        try (FileWriter fw = new FileWriter(filePath);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Line 1: Hello from Java File Handling");
            bw.newLine();
            bw.write("Line 2: Writing to a file");
            bw.newLine();
            bw.write("Line 3: Capgemini Training 2026");
        }
        System.out.println("\nFile written: " + filePath);

        // Read from file (BufferedReader)
        System.out.println("File contents:");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println("  " + line);
        }

        // Append to file
        try (FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Line 4: Appended line");
            bw.newLine();
        }

        // File info using java.io.File
        File f = new File(filePath);
        System.out.println("\nFile info:");
        System.out.println("  Name    : " + f.getName());
        System.out.println("  Size    : " + f.length() + " bytes");
        System.out.println("  Exists  : " + f.exists());
        System.out.println("  CanRead : " + f.canRead());

        // NIO – Files utility (Java 7+)
        System.out.println("\nAll lines via NIO:");
        Files.readAllLines(Path.of(filePath)).forEach(l -> System.out.println("  " + l));

        // Clean up
        f.delete();
        System.out.println("File deleted.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Synchronization ===");
        synchronizationDemo();

        System.out.println("\n=== File Handling ===");
        fileHandlingDemo();
    }
}
