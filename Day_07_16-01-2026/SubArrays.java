// Day 7 – Subarrays: Sliding Window and Two Pointers

public class SubArrays {

    // Max sum subarray of size k (Sliding Window)
    static int maxSumWindow(int[] arr, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++)
            windowSum += arr[i];
        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // Longest subarray with sum == k (Two Pointers / prefix sum for positive nums)
    static int longestSubarrayWithSum(int[] arr, int k) {
        int maxLen = 0, sum = 0, left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > k && left <= right)
                sum -= arr[left++];
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Two Sum – find pair that adds to target (Two Pointers on sorted array)
    static int[] twoSum(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int s = sorted[left] + sorted[right];
            if (s == target)
                return new int[] { sorted[left], sorted[right] };
            else if (s < target)
                left++;
            else
                right--;
        }
        return new int[] {};
    }

    // Kadane's Algorithm – maximum contiguous subarray sum
    static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        System.out.println("Max sum window k=3    : " + maxSumWindow(arr, 3));

        int[] arr2 = { 1, 2, 3, 1, 1, 1, 1 };
        System.out.println("Longest subarray sum=5: " + longestSubarrayWithSum(arr2, 5));

        int[] sorted = { 1, 2, 3, 4, 6 };
        int[] pair = twoSum(sorted, 6);
        System.out.println("Two sum target=6      : [" + pair[0] + ", " + pair[1] + "]");

        int[] kadane = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Kadane max subarray   : " + maxSubarraySum(kadane));
    }
}
