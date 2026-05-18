class Solution {
    String ans = "";
    int p1=-1,p2=-1;
    public void solve(String s, int i, int j){
        if(i==j || i>j){
            if(p1!=-1 && ans.length()<p2-p1+1){
                ans = s.substring(p1,p2);
                p1=-1;
            }
            return;
        }
        if(s.charAt(i)==s.charAt(j)){
            solve(s,i+1,j-1);
            if(p1==-1){
                p1=i;
                p2=j;
            }
            return;
        }
        solve(s,i+1,j);
        solve(s,i,j-1);
    }
    public String longestPalindrome(String s) {
        solve(s,0,s.length()-1);
        return ans;
    }
}
