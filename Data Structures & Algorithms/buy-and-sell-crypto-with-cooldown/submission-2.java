class Solution {
    public int solve(int[] prices, int n, int i,int buy,int dp[][]){
        if(i>=n){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int ans = 0;
        if(buy==1){
            ans = Math.max(solve(prices,n,i+1,1,dp),solve(prices,n,i+1,0,dp)-prices[i]); 
        }
        else{
            ans = Math.max(solve(prices,n,i+1,0,dp),solve(prices,n,i+2,1,dp)+prices[i]);
        }
        dp[i][buy] = ans;
        return ans;
    }
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,prices.length,0,1,dp);
        
    }
}
