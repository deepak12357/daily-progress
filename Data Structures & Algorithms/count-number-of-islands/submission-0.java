class Solution {
    
    int n,ans,m;
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        n = grid.length; m = grid[0].length; ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, char[][] g){
        for(int[] d : dir){
            int x = d[0]+i, y = d[1]+j;
            if(x>=0 && y>=0 && x<n && y<m && g[x][y]=='1'){
                g[x][y]='0';
                dfs(x,y,g);
            }
        }
    }
}
