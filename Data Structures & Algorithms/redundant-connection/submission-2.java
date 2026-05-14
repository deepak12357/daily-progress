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
            int pu = find(e[0],parent), pv= find(e[1],parent);
            if(pu==pv){
                return new int[]{e[0],e[1]};
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
