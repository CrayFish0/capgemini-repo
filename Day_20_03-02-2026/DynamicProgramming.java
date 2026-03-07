// Day 20 – Dynamic Programming
// DP: Break a problem into overlapping sub-problems, store results (memoization/tabulation).

public class DynamicProgramming {

    // ===== 1. Fibonacci (memoization – top-down) =====
    static long[] memo = new long[1000];

    static long fibMemo(int n) {
        if (n <= 1)
            return n;
        if (memo[n] != 0)
            return memo[n];
        return memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
    }

    // ===== 2. Fibonacci (tabulation – bottom-up) =====
    static long fibTab(int n) {
        if (n <= 1)
            return n;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // ===== 3. 0/1 Knapsack =====
    static int knapsack(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++)
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight[i - 1]] + value[i - 1]);
            }
        return dp[n][capacity];
    }

    // ===== 4. Longest Common Subsequence (LCS) =====
    static int lcs(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = a.charAt(i - 1) == b.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[m][n];
    }

    // ===== 5. Coin Change (minimum coins) =====
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ===== 6. Climbing Stairs =====
    static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("Fib(40) memo : " + fibMemo(40));
        System.out.println("Fib(40) tab  : " + fibTab(40));

        int[] w = { 1, 3, 4, 5 }, v = { 1, 4, 5, 7 };
        System.out.println("Knapsack(cap=7): " + knapsack(w, v, 7));

        System.out.println("LCS('ABCBDAB','BDCAB'): " + lcs("ABCBDAB", "BDCAB"));

        System.out.println("CoinChange([1,5,6,9], 11): " + coinChange(new int[] { 1, 5, 6, 9 }, 11));

        System.out.println("ClimbStairs(10): " + climbStairs(10));
    }
}
