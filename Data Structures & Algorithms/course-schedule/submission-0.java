class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indeg = new int[n];
        HashMap<Integer,List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }
        for(int[] p : prerequisites){
            indeg[p[1]]++;
            g.get(p[0]).add(p[1]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int f = q.poll();
            c++;
            for(int t : g.get(f)){
                indeg[t]--;
                if(indeg[t]==0){
                    q.add(t);
                }
            }       
        }
        return n==c;
    }
}
