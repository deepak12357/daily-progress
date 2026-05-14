class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            dist[i]=(int)1e9;
            g.add(new ArrayList<>());
        }
        for(int[] t : times){
            g.get(t[0]).add(new int[]{t[2],t[1]});
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> Integer.compare(a.dis,b.dis));
        pq.offer(new Pair(0,k));
        dist[k]=0;
        int min = -1;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for(int[] nei : g.get(top.node)){
                int temp = top.dis+nei[0];
                if(dist[nei[1]]>temp){
                    dist[nei[1]]=temp;
                    pq.offer(new Pair(temp,nei[1]));
                }
            }          
        }
        dist[0]=-1;
        for(int i : dist){
            if(i==(int)1e9){
                return -1;
            }
            min = Math.max(min,i);
        }
        return min;
    }
}
class Pair{
    int dis;
    int node;
    Pair(int dis, int node){
        this.dis = dis;
        this.node = node;
    }
    
}
