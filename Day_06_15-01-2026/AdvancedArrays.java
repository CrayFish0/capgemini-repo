// Day 6 – Advanced Arrays: Sum, Min, Max, Searching

import java.util.Arrays;

public class AdvancedArrays {

    // Sum of all elements
    static int sum(int[] arr) {
        int total = 0;
        for (int v : arr)
            total += v;
        return total;
    }

    // Maximum element
    static int max(int[] arr) {
        int m = arr[0];
        for (int v : arr)
            if (v > m)
                m = v;
        return m;
    }

    // Minimum element
    static int min(int[] arr) {
        int m = arr[0];
        for (int v : arr)
            if (v < m)
                m = v;
        return m;
    }

    // Linear search
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    // Reverse an array in-place
    static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    // Second largest element
    static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > first) {
                second = first;
                first = v;
            } else if (v > second) {
                second = v;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 3, 27, 8, 42, 5, 19 };
        System.out.println("Array  : " + Arrays.toString(arr));
        System.out.println("Sum    : " + sum(arr));
        System.out.println("Max    : " + max(arr));
        System.out.println("Min    : " + min(arr));
        System.out.println("2nd max: " + secondLargest(arr));
        System.out.println("Search 42 at index: " + linearSearch(arr, 42));
        reverse(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
}
