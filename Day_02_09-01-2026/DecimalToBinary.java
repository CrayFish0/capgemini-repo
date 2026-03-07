// Day 2 – HOMEWORK: Decimal to Binary Conversion
// Convert a decimal (base-10) integer to its binary (base-2) representation.

public class DecimalToBinary {

    // Method 1: Using repeated division and remainder
    static String decimalToBinary(int decimal) {
        if (decimal == 0)
            return "0";
        StringBuilder binary = new StringBuilder();
        int n = decimal;
        while (n > 0) {
            binary.insert(0, n % 2); // prepend remainder
            n /= 2;
        }
        return binary.toString();
    }

    // Method 2: Using Java built-in
    static String builtIn(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    // Method 3: Recursive approach
    static void recursiveBinary(int n) {
        if (n == 0)
            return;
        recursiveBinary(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        int[] testValues = { 0, 1, 5, 10, 42, 100, 255 };

        System.out.printf("%-10s %-20s %-20s%n", "Decimal", "Manual", "Built-in");
        System.out.println("-".repeat(52));

        for (int val : testValues) {
            System.out.printf("%-10d %-20s %-20s%n",
                    val, decimalToBinary(val), builtIn(val));
        }

        System.out.print("\nRecursive binary of 42: ");
        recursiveBinary(42);
        System.out.println();
    }
}
