class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        boolean[][] b =  new boolean[n][n];
        for(int[] p : pre){
            b[p[0]][p[1]]= true;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(b[i][k]){
                    for(int j=0;j<n;j++){
                        b[i][j]= b[i][j] || b[k][j];
                    }
                }
            }
        }
        ArrayList<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            if(b[q[0]][q[1]]){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}