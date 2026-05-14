class Solution {
    public int solve(int i, int cost[], List<Integer> dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp.get(i)!=-1){
            return dp.get(i);
        }
        dp.set(i,Math.min(solve(i+1,cost,dp),solve(i+2,cost,dp))+cost[i]);
        return dp.get(i);
    }
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        List<Integer> dp = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            dp.add(-1);
        }
        return Math.min(solve(0,cost,dp),solve(1,cost,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = 0, prev1=0;
        int curr = 0;
        for(int i=2;i<=n;i++){
            curr = Math.min(prev2+cost[i-2],prev1+cost[i-1]);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}

