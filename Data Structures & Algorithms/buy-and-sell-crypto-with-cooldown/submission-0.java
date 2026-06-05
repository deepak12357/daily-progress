class Solution {
    public int solve(int[] prices, int n, int i,int buy){
        if(i>=n){
            return 0;
        }
        if(buy==-1){
            return Math.max(solve(prices,n,i+1,-1),solve(prices,n,i+1,i)); 
        }
        else{
            return Math.max(solve(prices,n,i+1,buy),solve(prices,n,i+2,-1)+prices[i]-prices[buy]);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(prices,prices.length,0,-1);
        
    }
}
