class Solution {

    public int solve(int amount, int[] coins, int i, int[][] dp){
        if(i==coins.length || amount < 0){
            return 0; 
        }
        if(amount==0){
            return 1;
        }
        if(dp[i][amount]!=0) return dp[i][amount];
        int ans = solve(amount,coins,i+1,dp)
        +solve(amount-coins[i],coins,i,dp);
        dp[i][amount]=ans;
        return ans;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        return solve(amount,coins,0,dp);
    }
}
