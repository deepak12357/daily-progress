class Solution {
    public int solve(int[] stones, int n,int target, int i,int curr){
        if(curr>=target){
            return curr;
        }
        if(i==n) return Integer.MAX_VALUE;
        return Math.min(solve(stones,n,target,i+1,curr)
        , solve(stones,n,target,i+1,curr+stones[i]));
    }
    public int lastStoneWeightIIRec(int[] stones) {
        int stoneSum = 0;
        for(int i : stones){
            stoneSum+=i;
        }
        int target = stoneSum/2;
        int curr = solve(stones,stones.length,target,0,0);
        return Math.abs(stoneSum-2*curr);
    }
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for(int i : stones){
            stoneSum+=i;
        }
        int target = stoneSum/2;
        int n=stones.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]=dp[i-1][j];
                if(stones[i-1]<=j)
                    dp[i][j]=dp[i][j]||dp[i-1][j-stones[i-1]];
            }
        }
        int maxVal = 0;
        for(int i=target;i>=0;i--){
            if(dp[n][i]){
                maxVal=i;
                break;
            }
        }
        return stoneSum - 2 * maxVal;
    }

}