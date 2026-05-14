class Solution {

    public int solve(String t1, String t2, int n1, int n2, int[][] dp){
        if(n1==0 || n2==0) return 0;
        if(dp[n1-1][n2-1]!=-1){
            return dp[n1-1][n2-1];
        }
        if(t1.charAt(n1-1)==t2.charAt(n2-1)){
            dp[n1-1][n2-1]=1 + solve(t1,t2,n1-1,n2-1,dp);
            return dp[n1-1][n2-1];
        }
        dp[n1-1][n2-1] = Math.max(solve(t1,t2,n1-1,n2,dp), solve(t1,t2,n1,n2-1,dp));
        return dp[n1-1][n2-1];
    }
    public int longestCommonSubsequenceMemo(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(text1,text2,text1.length(), text2.length(),dp);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length()+1,n=text2.length()+1;
        int [][] dp = new int[m][n];
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]= Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
            
        }
        return dp[0][0];
     }
}
