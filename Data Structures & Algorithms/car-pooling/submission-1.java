class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)-> a[1]-b[1]);
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int[] trip : trips){
           int passenger = trip[0], source = trip[1], destination = trip[2];
            while(!q.isEmpty() && source >=q.peek()[1]){
                int[] f = q.peek();
                capacity+=f[0];
                q.remove();
            }
            q.offer(new int[]{passenger,destination});
            capacity-=passenger;
            if(capacity<0){
                return false;
            }
        }

        return true;
    }
}