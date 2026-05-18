class Solution {
    int parent[], rank[];
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n) return false;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i]=1; 
        }

        for(int[] e : edges){
            int u = e[0], v=e[1];
            int pu = find(u), pv = find(v);
            if(pu==pv){
                return false;
            }
            if(rank[pu]>rank[pv]){
                parent[pv]=pu;
            }
            else if(rank[pu]<rank[pv]){
                parent[pu]=pv;
            }
            else{
                parent[pv]=pu;
                rank[pu]++;
            }
        }
        return true;

    }
    public int find(int u){
        while(parent[u]!=u){
            u=parent[u];
        }
        return u;
    }
}
