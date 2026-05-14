class Solution {
    public int solve(int i,int n,int nums[],List<Integer> dp){
        if(i>=n){
            return 0;
        }
        if(dp.get(i)!=-1){
            return dp.get(i);
        }
        dp.set(i,Math.max(solve(i+2,n,nums,dp)+nums[i],solve(i+1,n,nums,dp)));
        return dp.get(i);
    }
    public int rob(int[] nums) {
        int i=0,n=nums.length;
        List<Integer> dp = new ArrayList<>(n+1);
        for(i=0;i<=n;i++){
            dp.add(-1);
        }
        return solve(0,n,nums,dp);
    }
}
