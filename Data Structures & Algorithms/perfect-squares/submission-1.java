class Solution {
    public int solve(int[] sq, int n, int[] dp){
        if(n==1 || n==0) return n;
        if(dp[n]!=-1) return dp[n];
        int ans = n;
        for(int i=sq.length-1;i>0;i--){
            if(n<sq[i]) continue;
            ans = Math.min(ans,solve(sq,n-sq[i],dp)+1);
        }
        dp[n]=ans;
        return ans;
    }
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        int sqrtN = (int)Math.sqrt(n);
        int square[] = new int[sqrtN+1];
        for(int i=1;i<=sqrtN;i++){
            square[i]=i*i;
        }
        return solve(square,n,dp);
    }
}