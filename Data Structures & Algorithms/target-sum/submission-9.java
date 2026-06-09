class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int newTarget = (sum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[newTarget + 1][n + 1];

        dp[0][0] = 1;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = nums[j - 1] == 0 ? 2 * dp[0][j - 1] : dp[0][j - 1];
        }

        for (int i = 1; i <= newTarget; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (i >= nums[j - 1]) {
                    dp[i][j] += dp[i - nums[j - 1]][j - 1];
                }
            }
        }

        return dp[newTarget][n];
    }
}