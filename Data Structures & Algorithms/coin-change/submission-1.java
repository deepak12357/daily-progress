class Solution {
    public int solve(int[] coins,int n,int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            int temp = solve(coins,n,amount-coins[j]);
            if(temp!=Integer.MAX_VALUE){
                ans=Math.min(temp+1,ans);
            }  
        }
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins,coins.length,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        return 0;
    }
}
