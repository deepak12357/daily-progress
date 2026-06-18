class Solution {
    public int solve(int[] p, int n, int i, int M, int isAlice){
        if(i>=n) return 0;
        int pilesSum = 0;
        int result = isAlice==1 ? -1 : Integer.MAX_VALUE;

        for(int j=i;j<Math.min(n,2*M+i);j++){
            pilesSum+=p[j];
            if(isAlice==1){
                result = Math.max(result, pilesSum + solve(p,n,j+1,Math.max(M,j-i+1),0));
            }
            else{
                result = Math.min(result, solve(p,n,j+1,Math.max(M,j-i+1),1));
            }
        }
        return result;
        
    }
    public int stoneGameII(int[] piles) {
        return solve(piles,piles.length,0,1,1);
    }
}