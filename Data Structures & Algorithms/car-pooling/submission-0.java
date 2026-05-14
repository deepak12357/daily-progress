class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)-> a[1]-b[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] arr : trips){
            q.offer(new int[]{arr[0],arr[1],arr[2]});
            map.put(arr[2],arr[0]);
        }

        while(!q.isEmpty()){
            int[] f = q.poll();
            int passenger = f[0], source = f[1], destination = f[2];
            System.out.println(source);
            if(map.get(source)!=null){
                capacity+=map.get(source);
            }
            capacity-=passenger;
            if(capacity <0){
                return false;
            }
        }
        return true;
    }
}