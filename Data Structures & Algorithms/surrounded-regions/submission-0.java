class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] vis;
    int m,n;
    public boolean check(int i,int j){
        if(i<n && j<m && i>=0 && j>=0){
            return true;
        }
        return false;
    }
    public boolean dfs(char[][] b, int i, int j){
        vis[i][j]=1;
        if(!check(i,j)){
            return false;
        }
        boolean temp = true;
        for(int[] d : dir){
            int x = i+d[0], y = j+d[1];
            if(!check(x,y)){
                temp=false;
            }else{
                if(b[x][y]=='O' && vis[x][y]!=1)
                    temp = temp && dfs(b,x,y);
            }
        }
        if(temp){
            b[i][j]='X';
        }
        return true;
    }
    public void solve(char[][] board) {
        n = board.length; m=board[0].length;
        vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }

    }
}
