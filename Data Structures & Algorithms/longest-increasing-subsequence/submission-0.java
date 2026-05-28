class Solution {
    public int solve(int[] nums,int n,int i){
        if(i==n){
            return 1;
        }
        int ans = 0;
        for(int j=i+1;j<n;j++){
            if(nums[j]>nums[i]){
                ans = Math.max(ans,solve(nums,n,j)+1);
            }
        }
        return Math.max(ans,solve(nums,n,i+1));
    }
    public int lengthOfLIS(int[] nums) {
        return solve(nums,nums.length,0);
    }
}
