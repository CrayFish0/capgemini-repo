// Day 7 – Scanner: reading user input
// (Run in terminal/IDE where stdin is available)

import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your GPA: ");
        double gpa = sc.nextDouble();

        System.out.println("\n--- Summary ---");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.printf("GPA  : %.2f%n", gpa);

        // Reading multiple integers on one line (e.g., "3 5")
        System.out.print("\nEnter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum  : " + (a + b));

        sc.close();
    }
}
