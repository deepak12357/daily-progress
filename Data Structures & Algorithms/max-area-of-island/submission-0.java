class Solution {

    int n,ans,m;
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length; m = grid[0].length; ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans = Math.max(ans,dfs(i,j,grid));
                }
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int[][] g){
        if(i<0 || j<0 || i>=n || j>=m || g[i][j] == 0){
            return 0;
        }
        g[i][j]=0;
        return dfs(i+1,j,g)+dfs(i,j+1,g)+dfs(i-1,j,g)+dfs(i,j-1,g)+1;
    }
}

