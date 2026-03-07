// Day 3 – Quick Sort, Merge Sort, and Linked List (concepts)

import java.util.Arrays;

public class Sorting {

    // ===================== QUICK SORT =====================
    // Pivot-based divide-and-conquer. Average O(n log n), worst O(n²).
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ===================== MERGE SORT =====================
    // Divide into halves, sort, then merge. O(n log n) always.
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // ===================== LINKED LIST (Simple) =====================
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
        }
    }

    static class LinkedList {
        Node head;

        void add(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }

        void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        // Quick Sort
        int[] arr1 = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Before QuickSort: ");
        System.out.println(Arrays.toString(arr1));
        quickSort(arr1, 0, arr1.length - 1);
        System.out.print("After  QuickSort: ");
        System.out.println(Arrays.toString(arr1));

        // Merge Sort
        int[] arr2 = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.print("\nBefore MergeSort: ");
        System.out.println(Arrays.toString(arr2));
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.print("After  MergeSort: ");
        System.out.println(Arrays.toString(arr2));

        // Linked List
        System.out.println("\n=== Linked List ===");
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print();
    }
}
