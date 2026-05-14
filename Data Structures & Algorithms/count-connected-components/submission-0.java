class Solution {
    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
    boolean[] vis;
    public void dfs(int i){
        if(vis[i]){
            return;
        }
        vis[i]=true;
        for(int j : g.get(i)){
            dfs(j);
        }
        
    }
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] e: edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        vis = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i);
                cnt++;
            }
        }
        return cnt;
    }
}
