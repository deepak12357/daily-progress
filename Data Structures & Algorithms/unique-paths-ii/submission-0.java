class Solution {
    int m,n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][] dp = new int[m][n];
        return solve(grid,m,n,0,0,dp);
    }
    public int solve(int[][] grid,int m, int n, int i,int j,int[][] dp){
        if(i==m || j==n){
            return 0;
        }
        if(grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j] = solve(grid,m,n,i+1,j,dp)+solve(grid,m,n,i,j+1,dp);
        return dp[i][j];
    }


    public int uniquePathsWithObstaclesTab(int m, int n) {
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
}
