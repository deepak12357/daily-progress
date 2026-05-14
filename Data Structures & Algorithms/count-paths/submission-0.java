class Solution {
    public int solve(int m, int n, int i,int j,int[][] dp){
        if(i==m || j==n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j] = solve(m,n,i+1,j,dp)+solve(m,n,i,j+1,dp);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(m,n,0,0,dp);
    }
}
