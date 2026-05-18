class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
            rank[i]=1;
        }

        for(int[] e : edges){
            int u = e[0], v= e[1];
            if(find(u,parent)==find(v,parent)){
                return new int[]{u,v};
            }
            int pu = parent[u], pv = parent[v];
            if(rank[pu]>rank[pv]){
                parent[v]=pu;
            }
            else if(rank[pu]<rank[pv]){
                parent[u]=pv;
            }
            else{
                parent[v]=pu;
                rank[pu]++;
            }
        }
        return new int[0];
    }
    public int find(int u,int[] parent){
        int u1 = u;
        while(u!=parent[u]){
            u=parent[u];
        }
        parent[u1]=u;
        return u;
    }
}
