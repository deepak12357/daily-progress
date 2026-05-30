class Solution {
    public int solve(int n, int[] dp){
        if(n==1 || n==0) return n;
        if(dp[n]!=0) return dp[n];
        int ans = n;
        for(int i=(int)Math.sqrt(n);i>0;i--){
            ans = Math.min(ans,solve(n-(int)Math.pow(i,2),dp)+1);
        }
        dp[n]=ans;
        return ans;
    }
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        return solve(n,dp);
    }
}