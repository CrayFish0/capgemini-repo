// Day 19 – Searching Techniques: Linear, Binary, Jump, Interpolation

import java.util.Arrays;

public class SearchingTechniques {

    // 1. Linear Search – O(n)
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    // 2. Binary Search (iterative) – O(log n) – requires sorted array
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    // 3. Binary Search (recursive)
    static int binarySearchRec(int[] arr, int target, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid])
            return binarySearchRec(arr, target, lo, mid - 1);
        return binarySearchRec(arr, target, mid + 1, hi);
    }

    // 4. Jump Search – O(√n) – sorted array
    static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n)
                return -1;
        }
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n))
                return -1;
        }
        return arr[prev] == target ? prev : -1;
    }

    // 5. Interpolation Search – O(log log n) average – uniformly distributed sorted
    // array
    static int interpolationSearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi && target >= arr[lo] && target <= arr[hi]) {
            int pos = lo + (int) (((long) (hi - lo) * (target - arr[lo])) / (arr[hi] - arr[lo]));
            if (arr[pos] == target)
                return pos;
            else if (arr[pos] < target)
                lo = pos + 1;
            else
                hi = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] unsorted = { 64, 25, 12, 22, 11, 78, 42, 90 };
        int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted);

        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        System.out.println("Sorted  : " + Arrays.toString(sorted));

        int target = 42;
        System.out.println("\nSearching for: " + target);
        System.out.println("Linear         : index " + linearSearch(unsorted, target));
        System.out.println("Binary (iter)  : index " + binarySearch(sorted, target));
        System.out.println("Binary (rec)   : index " + binarySearchRec(sorted, target, 0, sorted.length - 1));
        System.out.println("Jump           : index " + jumpSearch(sorted, target));
        System.out.println("Interpolation  : index " + interpolationSearch(sorted, target));
    }
}
