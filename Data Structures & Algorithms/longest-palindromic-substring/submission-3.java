class Solution {
    String ans = "";
    public void solve(String s, int i, int j){
        if(i==j || i>j) return;
       
        if(s.charAt(i)==s.charAt(j) && ans.length() < j-i+1){
            System.out.println(i+" , "+j);
            int a=i,b=j;
            while(a<b && s.charAt(a)==s.charAt(b)){
                a++;b--;
            }
            if(a>=b){
                ans = s.substring(i,j+1);
                return;
            }
        }
        if(ans.length() < j-i){
            solve(s,i+1,j);
            solve(s,i,j-1);
        }
    }
    public String longestPalindrome(String s) {
       
        if(s.length()>0)
        ans = String.valueOf(s.charAt(0));
         solve(s,0,s.length()-1);
        return ans;
    }
}
