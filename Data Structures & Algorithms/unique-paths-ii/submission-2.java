class Solution {
    int m,n;
    public int uniquePathsWithObstaclesMemo(int[][] grid) {
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


    public int uniquePathsWithObstacles2D(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];

    // destination
    if(grid[m-1][n-1] == 1) return 0;
    dp[m-1][n-1] = 1;

    // last row
    for(int j = n-2; j >= 0; j--){
        if(grid[m-1][j] == 1) break;
        dp[m-1][j] = dp[m-1][j+1];
    }

    // last column
    for(int i = m-2; i >= 0; i--){
        if(grid[i][n-1] == 1) break;
        dp[i][n-1] = dp[i+1][n-1];
    }

    // rest of grid
    for(int i = m-2; i >= 0; i--){
        for(int j = n-2; j >= 0; j--){
            if(grid[i][j] == 1) continue;
            dp[i][j] = dp[i+1][j] + dp[i][j+1];
        }
    }

    return dp[0][0];
}
    public int uniquePathsWithObstacles(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==1){
                    dp[j]=0;
                }
                else
                    dp[j]=dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }
}
