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
    public int coinChangeRec(int[] coins, int amount) {
        int ans = solve(coins,coins.length,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        
        for(int i=0;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[amount]=0;
        for(int a=amount;a>=0;a--){
            for(int i=0;i<n;i++){
                int j = a-coins[i];
                if(j>=0 &&  dp[a]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[a]+1);
                }
                
            }
        }
        return dp[0] != Integer.MAX_VALUE ? dp[0] : -1;
    }
}
