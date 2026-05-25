class Solution {
    public int solve(int[] coins,int n,int amount,int i){
        if(amount==0){
            return 0;
        }
        if(i==n || amount<0){
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            int temp = solve(coins,n,amount-coins[j],j);
            if(temp!=Integer.MAX_VALUE){
                ans=Math.min(temp+1,ans);
            }  
        }
        return Math.min(ans,solve(coins,n,amount,i+1));
    }
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins,coins.length,amount,0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
