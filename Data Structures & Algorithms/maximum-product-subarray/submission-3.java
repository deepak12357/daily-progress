class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int temp, currMin = 1, currMax=1;
        for(int n : nums){
            temp = currMax;
            currMax = Math.max(currMax*n, Math.max(n,currMin*n));
            currMin= Math.min(temp*n, Math.min(n,currMin*n));
            res=Math.max(res,currMax);
        }
        return res;
    }
        
        
    
}
