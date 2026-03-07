// Day 21 – 0/1 Knapsack and Greedy Algorithm

public class KnapsackAndGreedy {

    // ===== 0/1 Knapsack – DP =====
    static int knapsack01(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++)
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        return dp[n][W];
    }

    // ===== Greedy: Activity Selection =====
    // Select the maximum number of non-overlapping activities.
    static void activitySelection(int[] start, int[] end) {
        // Sort by end time (already sorted below for simplicity)
        System.out.println("Activities selected:");
        int lastEnd = -1, count = 0;
        for (int i = 0; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                System.out.println("  Activity " + (i + 1) + " [" + start[i] + ", " + end[i] + "]");
                lastEnd = end[i];
                count++;
            }
        }
        System.out.println("Total selected: " + count);
    }

    // ===== Greedy: Minimum Coins =====
    static void greedyCoins(int[] coins, int amount) {
        // Greedy works correctly only for canonical coin systems (e.g., Indian
        // denominations)
        System.out.println("Coins to make " + amount + ":");
        int total = 0;
        for (int i = coins.length - 1; i >= 0 && amount > 0; i--) {
            int count = amount / coins[i];
            if (count > 0) {
                System.out.println("  " + coins[i] + " x " + count);
                total += count;
            }
            amount %= coins[i];
        }
        System.out.println("Total coins: " + total);
    }

    // ===== Greedy: Job Sequencing (maximize profit) =====
    static void jobSequencing(char[] job, int[] deadline, int[] profit) {
        int n = job.length;
        // Sort by profit descending (indices)
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++)
            idx[i] = i;
        java.util.Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);

        int maxDeadline = 0;
        for (int d : deadline)
            maxDeadline = Math.max(maxDeadline, d);

        char[] schedule = new char[maxDeadline + 1];
        boolean[] slotFree = new boolean[maxDeadline + 1];
        java.util.Arrays.fill(slotFree, true);

        int totalProfit = 0;
        for (int i : idx) {
            for (int j = deadline[i]; j >= 1; j--) {
                if (slotFree[j]) {
                    schedule[j] = job[i];
                    slotFree[j] = false;
                    totalProfit += profit[i];
                    break;
                }
            }
        }

        System.out.print("Job sequence: ");
        for (int i = 1; i <= maxDeadline; i++)
            if (!slotFree[i])
                System.out.print(schedule[i] + " ");
        System.out.println("\nTotal profit: " + totalProfit);
    }

    public static void main(String[] args) {
        // 0/1 Knapsack
        int[] wt = { 2, 3, 4, 5 }, val = { 3, 4, 5, 6 };
        System.out.println("0/1 Knapsack (W=5): " + knapsack01(wt, val, 5));

        // Activity Selection (sorted by finish time)
        System.out.println("\nActivity Selection:");
        int[] start = { 1, 3, 0, 5, 8, 5 }, end = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);

        // Greedy Coins
        System.out.println("\nGreedy Coins:");
        greedyCoins(new int[] { 1, 2, 5, 10, 20, 50, 100, 200, 500 }, 289);

        // Job Sequencing
        System.out.println("\nJob Sequencing:");
        char[] jobs = { 'a', 'b', 'c', 'd', 'e' };
        int[] deadlines = { 2, 1, 2, 1, 3 };
        int[] profits = { 20, 15, 10, 5, 1 };
        jobSequencing(jobs, deadlines, profits);
    }
}
