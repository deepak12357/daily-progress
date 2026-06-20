class Solution {
    public int maxProfit(int[] prices) {
        int maxi = -1;
        int mini = prices[0];
        int profit = 0;
        int buy = prices[0];

        for(int i=0;i<prices.length;i++){
            if(prices[i]<mini){
                mini=prices[i];maxi=prices[i];
            }
            maxi=Math.max(maxi,prices[i]);
            profit=Math.max(profit,maxi-mini);
        }
        return profit;
    }
}
