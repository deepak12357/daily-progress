class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        int c=0;
        boolean ans = true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                if(c==0){
                    c++;
                    ans = validPalindrome1(s,i+1,j) || validPalindrome1(s,i,j-1) ;
                }
                else{
                    return false;
                }
            }
            
            i++;j--;
        }
        return ans;
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


