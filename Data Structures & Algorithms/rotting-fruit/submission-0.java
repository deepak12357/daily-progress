class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;
     private int bfs(int[][] grid, Queue<int[]> q,int fresh) {
        boolean[][] visit = new boolean[ROWS][COLS];
        int min = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS &&
                        !visit[nr][nc] && grid[nr][nc] == 1) {
                        visit[nr][nc] = true;
                        fresh--;
                        if(fresh==0) return min;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            min++;
        }
        return -1;
    }
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length; COLS = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        return bfs(grid,q,fresh);
    }
}
