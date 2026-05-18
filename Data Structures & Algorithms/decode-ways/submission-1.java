class Solution {
    public int solve(String s, int n, int i, int[] dp){
        if(i==n){
            return 1;
        }  
        if(dp[i]!=0){
            return dp[i];
        }     
        int ans = 0;
        int temp = (int)s.charAt(i)- 48;
        if(temp==0){ return 0;}
        if(temp < 3 && i+1<n){
            int temp2 = (int)s.charAt(i+1)- 48;
            if(temp2==0){
                dp[i] = solve(s,n,i+2,dp);
                return dp[i];
            }
            if(temp2<=6){
                dp[i] = solve(s,n,i+1,dp)+solve(s,n,i+2,dp);
                return dp[i];
            }
        }
        dp[i] = solve(s,n,i+1,dp);
        return dp[i];
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        return solve(s,s.length(),0,dp);
    }
}
