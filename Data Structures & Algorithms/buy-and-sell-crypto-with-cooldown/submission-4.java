class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;

    int[][] dp = new int[n + 1][2];

    // dp[i][0] = max profit after day i, not holding stock
    // dp[i][1] = max profit after day i, holding stock

    dp[0][0] = 0;
    dp[0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {

        // Hold stock or buy today
        if (i >= 2) {
            dp[i][1] = Math.max(dp[i - 1][1],
                                dp[i - 2][0] - prices[i - 1]);
        } else {
            dp[i][1] = Math.max(dp[i - 1][1],
                                -prices[i - 1]);
        }

        // Not hold stock or sell today
        dp[i][0] = Math.max(dp[i - 1][0],
                            dp[i - 1][1] + prices[i - 1]);
    }

    return dp[n][0];
}
}
