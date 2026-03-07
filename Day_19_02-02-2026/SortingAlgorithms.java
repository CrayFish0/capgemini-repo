// Day 19 – Sorting Algorithms: Bubble, Selection, Insertion, Merge, Quick

import java.util.Arrays;

public class SortingAlgorithms {

    // 1. Bubble Sort – O(n²)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    // 2. Selection Sort – O(n²)
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            swap(arr, i, minIdx);
        }
    }

    // 3. Insertion Sort – O(n²) worst, O(n) best
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key)
                arr[j + 1] = arr[--j + 1];
            arr[j + 1] = key;
        }
    }

    // 4. Merge Sort – O(n log n)
    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] tmp = Arrays.copyOfRange(arr, l, r + 1);
        int i = 0, j = m - l + 1, k = l;
        while (i <= m - l && j <= r - l)
            arr[k++] = tmp[i] <= tmp[j] ? tmp[i++] : tmp[j++];
        while (i <= m - l)
            arr[k++] = tmp[i++];
        while (j <= r - l)
            arr[k++] = tmp[j++];
    }

    // 5. Quick Sort – O(n log n) avg
    static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi], i = lo - 1;
        for (int j = lo; j < hi; j++)
            if (arr[j] <= pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, hi);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static int[] sample() {
        return new int[] { 64, 34, 25, 12, 22, 11, 90 };
    }

    public static void main(String[] args) {
        int[] a = sample();
        bubbleSort(a);
        System.out.println("Bubble   : " + Arrays.toString(a));

        int[] b = sample();
        selectionSort(b);
        System.out.println("Selection: " + Arrays.toString(b));

        int[] c = sample();
        insertionSort(c);
        System.out.println("Insertion: " + Arrays.toString(c));

        int[] d = sample();
        mergeSort(d, 0, d.length - 1);
        System.out.println("Merge    : " + Arrays.toString(d));

        int[] e = sample();
        quickSort(e, 0, e.length - 1);
        System.out.println("Quick    : " + Arrays.toString(e));
    }
}
