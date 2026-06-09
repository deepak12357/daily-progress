class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sumNums = 0;
        for(int num : nums){
            sumNums+=num;
        }
        int n = nums.length;
        int newTarget = (sumNums+target)/2;
        if (Math.abs(target) > sumNums) return 0;
        if ((sumNums + target) % 2 != 0) return 0;
        int[][] dp = new int[newTarget+1][n+1];
        for(int i=0;i<n+1;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<newTarget+1;i++){
            for(int j=1;j<n+1;j++){
                if(i>=nums[j-1]){
                    dp[i][j] = dp[i][j-1] + dp[i-nums[j-1]][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
                
            }
        }
        return dp[newTarget][n];
    }
}
