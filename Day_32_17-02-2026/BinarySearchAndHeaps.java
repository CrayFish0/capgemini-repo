// Day 32 – Binary Search (advanced), Heaps, PriorityQueue

import java.util.*;

public class BinarySearchAndHeaps {

    // ===== Binary Search variants =====

    // Find first occurrence
    static int firstOccurrence(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                result = mid;
                hi = mid - 1;
            } else if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return result;
    }

    // Find last occurrence
    static int lastOccurrence(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                result = mid;
                lo = mid + 1;
            } else if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return result;
    }

    // Search in rotated sorted array
    static int searchRotated(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
                return mid;
            // Left half is sorted
            if (arr[lo] <= arr[mid]) {
                if (target >= arr[lo] && target < arr[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

    // ===== Heap using PriorityQueue =====
    static void kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        System.out.println(k + "th largest: " + minHeap.peek());
    }

    static void mergeKSortedArrays(int[][] arrays) {
        // Using a min-heap with [value, arrayIndex, elementIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arrays.length; i++)
            if (arrays[i].length > 0)
                pq.offer(new int[] { arrays[i][0], i, 0 });

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            result.add(curr[0]);
            int ai = curr[1], ei = curr[2];
            if (ei + 1 < arrays[ai].length)
                pq.offer(new int[] { arrays[ai][ei + 1], ai, ei + 1 });
        }
        System.out.println("Merged k arrays: " + result);
    }

    public static void main(String[] args) {
        int[] sorted = { 1, 2, 2, 3, 4, 4, 4, 5, 6 };
        System.out.println("First occurrence of 4: " + firstOccurrence(sorted, 4));
        System.out.println("Last  occurrence of 4: " + lastOccurrence(sorted, 4));

        int[] rotated = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Search 0 in rotated  : " + searchRotated(rotated, 0));

        kthLargest(new int[] { 3, 1, 5, 12, 2, 11 }, 3);

        mergeKSortedArrays(new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } });
    }
}
