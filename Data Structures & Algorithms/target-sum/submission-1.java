class Solution {
    public int solve(int[] nums, int target, int i){

        if(target==0 && i==nums.length){
            return 1;
        }
        if(i>=nums.length || target<0){
            return 0;
        }
        return solve(nums,target+nums[i],i+1)+solve(nums,target-nums[i],i+1);
    }
    public int findTargetSumWaysMemo(int[] nums, int target) {
        return solve(nums,target,0);
    }
    public int findTargetSumWays(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<=target;j++){
                if(j+nums[i]<=target && j-nums[i]>=0)
                    dp[i-1][target]=dp[i][j-nums[i]]+dp[i][j+nums[i]];
            }
        }
        return dp[0][target];
    } 
}
