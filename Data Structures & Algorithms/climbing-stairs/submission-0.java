class Solution {
    public int solve(int n, List<Integer> dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp.get(n)!=-1){
            return dp.get(n);
        }
        dp.set(n,solve(n-1,dp)+solve(n-2,dp));
        return dp.get(n);
    }
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            dp.add(-1);
        }
        return solve(n,dp);
    }
}
