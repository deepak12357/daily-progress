class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0], maxi=prices[0];
        int ans=0;
        for(int a : prices){
            if(mini>a){
                mini=a;
                maxi=a;
            }
            maxi=Math.max(maxi,a);
            ans = Math.max(ans,maxi-mini);
        }
        return ans;
    }
}
