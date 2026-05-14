

class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indeg = new int[n];
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }
        for(int[] p : prerequisites){
            indeg[p[0]]++;
            g.get(p[1]).add(p[0]);
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
            ans.add(f);
            for(int t : g.get(f)){
                indeg[t]--;
                if(indeg[t]==0){
                    q.add(t);
                }
            }       
        }

        if(n!=c){
            return new int[0];
        }

        int[] r = new int[n];
        for(int i=0;i<n;i++){
            r[i]=ans.get(i);
        }
        return r;
    }
}


