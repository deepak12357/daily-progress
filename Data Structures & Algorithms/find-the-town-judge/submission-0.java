class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,Integer> in = new HashMap<>();
        HashMap<Integer,Integer> out = new HashMap<>();

        for(int[] arr : trust){
            in.put(arr[1],in.getOrDefault(arr[1],0)+1);
            out.put(arr[0],in.getOrDefault(arr[0],0)+1);
        }
        for(int i=1;i<n+1;i++){
            if(out.get(i)==null){
                if(in.get(i)==n-1){
                    return i;
                }
            }
        }
        return -1;
    }
}