// Day 2 – Loops: for, while, do-while, enhanced-for, break, continue

public class Loops {
    public static void main(String[] args) {
        // --- for loop ---
        System.out.println("=== for loop ===");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // --- while loop ---
        System.out.println("\n=== while loop ===");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // --- do-while loop ---
        System.out.println("\n=== do-while loop ===");
        int j = 1;
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 5);
        System.out.println();

        // --- Nested loops (multiplication table) ---
        System.out.println("\n=== Nested loops – 3×3 table ===");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }

        // --- break ---
        System.out.println("\n=== break ===");
        for (int k = 1; k <= 10; k++) {
            if (k == 6)
                break;
            System.out.print(k + " ");
        }
        System.out.println();

        // --- continue ---
        System.out.println("\n=== continue (skip evens) ===");
        for (int k = 1; k <= 10; k++) {
            if (k % 2 == 0)
                continue;
            System.out.print(k + " ");
        }
        System.out.println();

        // --- enhanced for (for-each) ---
        System.out.println("\n=== enhanced for ===");
        int[] numbers = { 10, 20, 30, 40, 50 };
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
