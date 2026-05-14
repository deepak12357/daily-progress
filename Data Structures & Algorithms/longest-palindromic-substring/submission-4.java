class Solution {
    public int checkPalindrome(String s, int n, int i, int j){
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        int resLen = 1, res = 0;
        int n = s.length();
        for(int i=1;i<n;i++){
            int temp = checkPalindrome(s,n,i-1,i+1);
            if(temp > resLen){
                res = i-temp/2;
                resLen = temp;
            }
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                int temp = checkPalindrome(s,n,i-1,i);
                if(temp > resLen){
                    res = i-temp/2;
                    resLen = temp ;
                }
            }
        }
        return s.substring(res,res+resLen);
    }
}
