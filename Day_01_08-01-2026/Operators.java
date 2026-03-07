// Day 1 – Operators and Operator Precedence
// Reference: https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 3;

        // --- Arithmetic Operators ---
        System.out.println("=== Arithmetic ===");
        System.out.println("a + b  = " + (a + b));
        System.out.println("a - b  = " + (a - b));
        System.out.println("a * b  = " + (a * b));
        System.out.println("a / b  = " + (a / b)); // integer division
        System.out.println("a % b  = " + (a % b)); // modulus / remainder

        // --- Relational Operators ---
        System.out.println("\n=== Relational ===");
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));

        // --- Logical Operators ---
        System.out.println("\n=== Logical ===");
        boolean x = true, y = false;
        System.out.println("x && y : " + (x && y)); // AND
        System.out.println("x || y : " + (x || y)); // OR
        System.out.println("!x     : " + (!x)); // NOT

        // --- Bitwise Operators ---
        System.out.println("\n=== Bitwise ===");
        System.out.println("a & b  = " + (a & b)); // AND
        System.out.println("a | b  = " + (a | b)); // OR
        System.out.println("a ^ b  = " + (a ^ b)); // XOR
        System.out.println("~a     = " + (~a)); // complement
        System.out.println("a << 1 = " + (a << 1)); // left shift (* 2)
        System.out.println("a >> 1 = " + (a >> 1)); // right shift (/ 2)

        // --- Assignment Operators ---
        System.out.println("\n=== Assignment ===");
        int c = 5;
        c += 3;
        System.out.println("c += 3  → " + c);
        c -= 2;
        System.out.println("c -= 2  → " + c);
        c *= 4;
        System.out.println("c *= 4  → " + c);
        c /= 3;
        System.out.println("c /= 3  → " + c);
        c %= 4;
        System.out.println("c %= 4  → " + c);

        // --- Operator Precedence demo ---
        System.out.println("\n=== Precedence ===");
        // Multiplication before addition
        int result = 2 + 3 * 4; // 2 + 12 = 14 (NOT 20)
        System.out.println("2 + 3 * 4  = " + result);
        int resultParen = (2 + 3) * 4; // 5 * 4 = 20
        System.out.println("(2+3) * 4  = " + resultParen);
    }
}
