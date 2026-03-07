// Day 3 – Recursion
// A method that calls itself to solve sub-problems.

public class Recursion {

    // Factorial: n! = n * (n-1)!
    static long factorial(int n) {
        if (n <= 1)
            return 1; // base case
        return n * factorial(n - 1); // recursive case
    }

    // Fibonacci: F(n) = F(n-1) + F(n-2)
    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Sum of first n natural numbers
    static int sumN(int n) {
        if (n == 0)
            return 0;
        return n + sumN(n - 1);
    }

    // Power: base^exp
    static long power(int base, int exp) {
        if (exp == 0)
            return 1;
        return base * power(base, exp - 1);
    }

    // Binary search (recursive)
    static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid])
            return binarySearch(arr, target, low, mid - 1);
        return binarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {
        System.out.println("factorial(6)   = " + factorial(6));

        System.out.print("Fibonacci 0-9  : ");
        for (int i = 0; i < 10; i++)
            System.out.print(fibonacci(i) + " ");
        System.out.println();

        System.out.println("sum(10)        = " + sumN(10));
        System.out.println("2^10           = " + power(2, 10));

        int[] sorted = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        System.out.println("binarySearch(23) at index: " +
                binarySearch(sorted, 23, 0, sorted.length - 1));
    }
}
