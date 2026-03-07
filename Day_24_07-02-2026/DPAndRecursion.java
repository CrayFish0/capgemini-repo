// Day 24 – DP and Recursion Revision

public class DPAndRecursion {

    // ===== Subset Sum =====
    static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        return dp[n][target];
    }

    // ===== Longest Increasing Subsequence (LIS) =====
    static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // ===== Matrix Chain Multiplication =====
    static int matrixChain(int[] dims) {
        int n = dims.length - 1;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i] * dims[k + 1] * dims[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }

    // ===== Generate all subsets (Recursion + Backtracking) =====
    static void subsets(int[] arr, int idx, java.util.List<Integer> current) {
        if (idx == arr.length) {
            System.out.println(current);
            return;
        }
        // Exclude current element
        subsets(arr, idx + 1, current);
        // Include current element
        current.add(arr[idx]);
        subsets(arr, idx + 1, current);
        current.remove(current.size() - 1);
    }

    // ===== Generate permutations =====
    static void permute(int[] arr, int start) {
        if (start == arr.length) {
            System.out.println(java.util.Arrays.toString(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int tmp = arr[start];
            arr[start] = arr[i];
            arr[i] = tmp;
            permute(arr, start + 1);
            tmp = arr[start];
            arr[start] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println("SubsetSum {3,1,5,9,12} target=18: " + subsetSum(new int[] { 3, 1, 5, 9, 12 }, 18));

        System.out.println("LIS {10,9,2,5,3,7,101,18}: " + lis(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

        System.out.println("Matrix Chain [1,2,3,4]: " + matrixChain(new int[] { 1, 2, 3, 4 }));

        System.out.println("\nAll subsets of {1,2,3}:");
        subsets(new int[] { 1, 2, 3 }, 0, new java.util.ArrayList<>());

        System.out.println("\nPermutations of {1,2,3}:");
        permute(new int[] { 1, 2, 3 }, 0);
    }
}
