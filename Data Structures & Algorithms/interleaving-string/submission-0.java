class Solution {
    public boolean solve(String s1, String s2, String s3,int i, int j){
        int k = i+j;
        if(s3.length()==k){
            return i==s1.length() && j==s2.length();
        }     
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            ans  = ans || solve(s1,s2,s3,i+1,j);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            ans = ans || solve(s1,s2,s3,i,j+1);
        }
        return ans ;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return solveByTab(s1,s2,s3);
    }
    public boolean solveByTab(String s1, String s2, String s3){
        
        int n = s1.length(),m=s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp  = new boolean[n+1][m+1];
        dp[n][m] = true;
        int k;
        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                k=i+j;
                if(i<n && s1.charAt(i)==s3.charAt(k)){
                    dp[i][j]  = dp[i+1][j];
                }
                if(j<m && s2.charAt(j)==s3.charAt(k)){
                    dp[i][j] =  dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
