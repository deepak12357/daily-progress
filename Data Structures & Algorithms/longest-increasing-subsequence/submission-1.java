class Solution {
    public int solve(int[] nums,int n,int i,int[] dp){
        if(i==n){
            return 1;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int ans = 0;
        for(int j=i+1;j<n;j++){
            if(nums[j]>nums[i]){
                ans = Math.max(ans,solve(nums,n,j,dp)+1);
            }
        }
        dp[i] = Math.max(ans,solve(nums,n,i+1,dp));
        return dp[i];
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        return solve(nums,nums.length,0,dp);
    }
}
