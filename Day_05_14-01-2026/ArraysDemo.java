// Day 5 – Arrays and 2D Arrays

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // ===== 1D Arrays =====
        int[] marks = { 85, 92, 78, 95, 60 };
        System.out.println("Marks array   : " + Arrays.toString(marks));
        System.out.println("Length        : " + marks.length);
        System.out.println("Element [2]   : " + marks[2]);

        // Traversal
        int sum = 0;
        for (int m : marks)
            sum += m;
        System.out.println("Sum           : " + sum);
        System.out.printf("Average       : %.2f%n", (double) sum / marks.length);

        // Sort
        Arrays.sort(marks);
        System.out.println("Sorted        : " + Arrays.toString(marks));

        // ===== 2D Arrays =====
        System.out.println("\n=== 2D Array (Matrix) ===");
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Print matrix
        for (int[] row : matrix) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }

        // Matrix transpose
        System.out.println("\nTranspose:");
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                transpose[c][r] = matrix[r][c];

        for (int[] row : transpose) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }

        // ===== Jagged Array =====
        System.out.println("\nJagged Array:");
        int[][] jagged = new int[3][];
        jagged[0] = new int[] { 1 };
        jagged[1] = new int[] { 2, 3 };
        jagged[2] = new int[] { 4, 5, 6 };
        for (int[] row : jagged)
            System.out.println(Arrays.toString(row));
    }
}
