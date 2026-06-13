class Solution {
    public boolean solve(String s1, String s2, String s3, int i, int j){
        if(i+j==s3.length()){
            return true;
        }
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            ans = solve(s1,s2,s3,i+1,j);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            ans = ans || solve(s1,s2,s3,i,j+1);
        }
        return ans;
    }
    public boolean isInterleaverec(String s1, String s2, String s3) {
        if(s3.length()-s1.length() != +s2.length()) return false;
        return solve(s1,s2,s3,0,0);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if(k-m!=n) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-2)){
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-2)){
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
