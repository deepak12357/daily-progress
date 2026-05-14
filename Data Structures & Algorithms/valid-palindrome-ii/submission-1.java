class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        boolean ans = true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return validPalindrome1(s,i+1,j) || validPalindrome1(s,i,j-1) ;
            }
            i++;j--;
        }
        return true;
    }

    public boolean validPalindrome1(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}


