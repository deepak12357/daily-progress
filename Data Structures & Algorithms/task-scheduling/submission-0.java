class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for(char task : tasks){
            taskFreq[task-'A']++;
            
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> b - a );
        

        // PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->b.coolTime-a.coolTime);
        for(int i=0;i<26;i++){
            if(taskFreq[i]>0){
                pq.offer(taskFreq[i]);
            }
        }
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int remaining = pq.poll() - 1;
                if(remaining > 0){
                    cooldown.add(new int[]{remaining, n+time});
                }
            }

            if(!cooldown.isEmpty()){
                int c = cooldown.peek()[0];
                int t = cooldown.peek()[1];
                if(t==time){
                    pq.offer(c);
                    cooldown.poll();
                }
            }
        }
        return time;
    }
}
