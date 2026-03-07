// Day 11 – Exception Handling
// try-catch-finally, throw, throws, checked vs unchecked exceptions

public class ExceptionHandling {

    // Custom checked exception
    static class InsufficientFundsException extends Exception {
        double amount;

        InsufficientFundsException(double amount) {
            super("Insufficient funds. Short by: " + amount);
            this.amount = amount;
        }
    }

    // Custom unchecked exception
    static class NegativeAmountException extends RuntimeException {
        NegativeAmountException(String msg) {
            super(msg);
        }
    }

    static class BankAccount {
        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        void withdraw(double amount) throws InsufficientFundsException {
            if (amount < 0)
                throw new NegativeAmountException("Amount cannot be negative.");
            if (amount > balance)
                throw new InsufficientFundsException(amount - balance);
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Balance: " + balance);
        }
    }

    // Method that declares checked exception
    static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        // Basic try-catch-finally
        System.out.println("=== Basic try-catch ===");
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs.");
        }

        // Multiple catch blocks
        System.out.println("\n=== Multiple catch ===");
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }

        // ArrayIndexOutOfBounds
        System.out.println("\n=== Array bounds ===");
        try {
            int[] arr = { 1, 2, 3 };
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Custom exceptions
        System.out.println("\n=== Custom Exception ===");
        BankAccount acc = new BankAccount(500.0);
        try {
            acc.withdraw(200);
            acc.withdraw(400); // should throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Custom exception: " + e.getMessage());
        }

        // Multi-catch (Java 7+)
        System.out.println("\n=== Multi-catch ===");
        try {
            Object obj = "hello";
            Integer i = (Integer) obj; // ClassCastException
        } catch (ClassCastException | NullPointerException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
        }
    }
}
