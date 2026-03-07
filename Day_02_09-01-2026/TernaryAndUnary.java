// Day 2 – Ternary Operator, Increment/Decrement, Logical Operators

public class TernaryAndUnary {
    public static void main(String[] args) {
        // --- Ternary Operator ---
        // Syntax: condition ? valueIfTrue : valueIfFalse
        int age = 18;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age " + age + " is: " + status);

        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + " = " + max);

        // Nested ternary (grade classifier)
        int marks = 75;
        String grade = (marks >= 90) ? "A" : (marks >= 75) ? "B" : (marks >= 60) ? "C" : "F";
        System.out.println("Marks " + marks + " -> Grade: " + grade);

        // --- Increment & Decrement Operators ---
        System.out.println("\n=== Increment / Decrement ===");
        int x = 5;
        System.out.println("x        = " + x);
        System.out.println("x++  (post): " + x++); // uses 5, then becomes 6
        System.out.println("After x++: " + x);
        System.out.println("++x  (pre) : " + ++x); // becomes 7, then uses 7
        System.out.println("x--  (post): " + x--); // uses 7, then becomes 6
        System.out.println("--x  (pre) : " + --x); // becomes 5, then uses 5

        // --- Logical Operators ---
        System.out.println("\n=== Logical Operators ===");
        boolean p = true, q = false;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q (AND) : " + (p && q));
        System.out.println("p || q (OR)  : " + (p || q));
        System.out.println("!p     (NOT) : " + (!p));

        // Short-circuit evaluation
        int n = 0;
        // Right side not evaluated because left side is false
        boolean result = (n != 0) && (10 / n > 1);
        System.out.println("\nShort-circuit AND (n=0): " + result + " (no exception)");
    }
}
