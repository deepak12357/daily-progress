class Solution {
    int n,m;
    int[][] dis = {{1,0},{0,1},{-1,0},{0,-1}};
    public Boolean solve(int[][] h, int[][] vis, int i, int j){
        boolean at = false, pa = false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[] f = q.poll();
            for(int[] d : dis){
                int x=d[0]+f[0];
                int y=d[1]+f[1];
                if(x<0 || y<0){
                    pa = true;
                    continue;
                }
                else if(x>=n || y>=m){
                    at = true;
                    continue;
                }
                else if(vis[x][y]!=1 && h[f[0]][f[1]]>=h[x][y]){
                    q.offer(new int[]{x,y});
                    vis[x][y]=1;
                }
            }
            if(at && pa){
                return true;
            }
        }
        return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        n = heights.length; m = heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int [][] vis = new int[n][m];
                if(solve(heights,vis,i,j)){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;     
    }
}
