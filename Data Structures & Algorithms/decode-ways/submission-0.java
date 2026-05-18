class Solution {
    public int solve(String s, int n, int i, int pre){
        if(i==n){
            if(pre>-1) return 0;
            return 1;
        }       
        int temp = (int)s.charAt(i)- 48;
        if(pre!=-1){
            if(temp<=6){
                return solve(s,n,i+1,-1);
            }
            else{
                return 0;
            }
        }
        if(temp==0){
            return 0;
        }
        if(temp<3){
            return solve(s,n,i+1,temp) + solve(s,n,i+1,-1);
        }
        return solve(s,n,i+1,-1);
    }
    public int numDecodings(String s) {
        return solve(s,s.length(),0,-1);
    }
}
