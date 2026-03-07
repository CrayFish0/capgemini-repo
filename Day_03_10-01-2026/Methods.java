// Day 3 – Methods / Functions
// Method declaration, parameters, return types, overloading

public class Methods {

    // Method with no parameters and no return
    static void greet() {
        System.out.println("Hello from a method!");
    }

    // Method with parameters and return value
    static int add(int a, int b) {
        return a + b;
    }

    // Method overloading (same name, different parameters)
    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method that returns a String
    static String greetUser(String name) {
        return "Hello, " + name + "!";
    }

    // Factorial using a loop
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }

    // Check if a number is prime
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        greet();
        System.out.println("add(3,4)        = " + add(3, 4));
        System.out.println("add(1.5, 2.5)   = " + add(1.5, 2.5));
        System.out.println("add(1,2,3)      = " + add(1, 2, 3));
        System.out.println(greetUser("Capgemini"));
        System.out.println("5!              = " + factorial(5));
        System.out.println("isPrime(17)     = " + isPrime(17));
        System.out.println("isPrime(18)     = " + isPrime(18));
    }
}
