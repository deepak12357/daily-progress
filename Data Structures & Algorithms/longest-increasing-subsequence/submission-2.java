class Solution {
    public int solve(int[] nums,int n,int i,int[] dp){
        
        if(dp[i]!=0){
            return dp[i];
        }
        int ans = 1;
        for(int j=i+1;j<n;j++){
            if(nums[j]>nums[i]){
                ans = Math.max(ans,solve(nums,n,j,dp)+1);
            }
        }
        dp[i] = ans;
        return dp[i];
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,solve(nums,nums.length,i,dp));
        }
        return ans;
    }
}
