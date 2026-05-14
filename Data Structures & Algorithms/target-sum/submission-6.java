class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        target = (target+sum);
        if(target % 2 !=0) return 0; 
        return solveByTab1D(nums,n,target/2);
    }

    public int solveByTab(int[] nums,int n,int target){
        int[][] dp = new int[n+1][target+1];
        dp[0][target]=1;
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
        for(int i=0;i<n;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
