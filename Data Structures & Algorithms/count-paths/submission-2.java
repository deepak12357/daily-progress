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
    public int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(m,n,0,0,dp);
    }

    public int uniquePathsRec(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }
}
