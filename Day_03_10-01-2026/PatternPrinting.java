// Day 3 – Pattern Printing
// Classic star/number patterns using nested loops

public class PatternPrinting {
    public static void main(String[] args) {
        int n = 5;

        // 1. Right-angle triangle (stars)
        System.out.println("1. Right-angle triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        // 2. Inverted triangle
        System.out.println("\n2. Inverted triangle");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        // 3. Pyramid
        System.out.println("\n3. Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }

        // 4. Diamond
        System.out.println("\n4. Diamond");
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int sp = 1; sp <= n - i; sp++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }

        // 5. Number triangle
        System.out.println("\n5. Number triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }

        // 6. Floyd's triangle
        System.out.println("\n6. Floyd's triangle");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(num++ + " ");
            System.out.println();
        }
    }
}
