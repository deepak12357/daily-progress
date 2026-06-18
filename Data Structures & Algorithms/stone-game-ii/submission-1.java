class Solution {
    public int solve(int[] p, int n, int i, int M, int isAlice,int[][][] dp){
        if(i>=n) return 0;
        if(dp[i][M][isAlice]!=-1){
            return dp[i][M][isAlice];
        }
        int pilesSum = 0;
        int result = isAlice==1 ? -1 : Integer.MAX_VALUE;

        for(int j=i;j<Math.min(n,2*M+i);j++){
            pilesSum+=p[j];
            if(isAlice==1){
                result = Math.max(result, pilesSum + solve(p,n,j+1,Math.max(M,j-i+1),0,dp));
            }
            else{
                result = Math.min(result, solve(p,n,j+1,Math.max(M,j-i+1),1,dp));
            }
        }
        dp[i][M][isAlice] = result;
        return result;
        
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n+1][n+1][2];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        return solve(piles,n,0,1,1,dp);
    }
}