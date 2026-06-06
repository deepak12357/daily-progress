class Solution {
    public int solve(int[] prices, int n, int i,int buy,int dp[][]){
        if(i>=n){
            return 0;
        }
        if(dp[i][buy]!=0){
            return dp[i][buy];
        }
        int ans = 0;
        if(buy==5001){
            ans = Math.max(solve(prices,n,i+1,5001,dp),solve(prices,n,i+1,i,dp)); 
        }
        else{
            ans = Math.max(solve(prices,n,i+1,buy,dp),solve(prices,n,i+2,5001,dp)+prices[i]-prices[buy]);
        }
        dp[i][buy] = ans;
        return ans;
    }
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][5002];
        return solve(prices,prices.length,0,5001,dp);
        
    }
}
