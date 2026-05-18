class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        target = (target+sum)/2;
        return solveByTab1D(nums,n,target);
    }

    public int solveByTab(int[] nums,int n,int target){
        int[][] dp = new int[n+1][target+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }

    public int solveByTab1D(int[] nums,int n,int target){
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<target;j++){
                if(j>=nums[i-1])
                    dp[j] = dp[j]+dp[j-nums[i-1]];
                else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }
}
