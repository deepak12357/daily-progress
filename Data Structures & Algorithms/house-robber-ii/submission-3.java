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
    public int rob1(int[] nums) {
        int i=0,n=nums.length;
        if(n==1){
            return nums[0];
        }
        List<Integer> dp = new ArrayList<>(n+1);
        List<Integer> dp1 = new ArrayList<>(n+1);
        for(i=0;i<=n;i++){
            dp.add(-1);
            dp1.add(-1);
        }
        return Math.max(solve(0,n-1,nums,dp),solve(1,n,nums,dp1));
    }
    public int rob(int[] nums) {
        int i=0,n=nums.length;
        List<Integer> dp = new ArrayList<>(n+2);
        List<Integer> dp1 = new ArrayList<>(n+2);
        for(i=0;i<=n+1;i++){
            dp.add(-1);
        }
        dp.set(0,0);
        dp.set(1,0);
        dp1.addAll(dp);
        for(i=2;i<n+1;i++){
            dp.set(i,Math.max(dp.get(i-1),dp.get(i-2)+nums[i-2]));
            dp1.set(i+1,Math.max(dp1.get(i),dp1.get(i-1)+nums[i-1]));
        }
        return Math.max(dp.get(n),dp1.get(n+1));
    }

}
