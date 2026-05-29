class Solution {
    public int solve(int[] nums, int n, int target, int[] dp){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=0){
            return dp[target];
        }
        int ans = 0;
        for(int num : nums){
            ans+= solve(nums,n,target-num,dp);
        }
        dp[target] = ans;
        return ans;
    }
    public int combinationSum4Rec(int[] nums, int target) {
        int[] dp = new int[target+1];
        return solve(nums,nums.length,target,dp);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}