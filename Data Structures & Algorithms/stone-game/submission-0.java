class Solution {

    Integer[][] dp;

    public int solve(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = Math.max(
                piles[i] - solve(piles, i + 1, j),
                piles[j] - solve(piles, i, j - 1)
        );
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];

        return solve(piles, 0, n - 1) > 0;
    }
}