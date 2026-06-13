class Solution {
    public Boolean solve(String s1, String s2, String s3, int i, int j){
        if(i+j==s3.length()){
            return true;
        }
        if(Math.abs(i-j)>1){
            return false;
        }
        Boolean ans = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            ans = solve(s1,s2,s3,i+1,j);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            ans = ans || solve(s1,s2,s3,i,j+1);
        }
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return solve(s1,s2,s3,0,0);
    }
}
