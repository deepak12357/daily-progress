class Solution {
    public int maxProduct(int[] nums) {
        
        int ans = nums[0];
        int temp = nums[0];
        int sign;

        if(temp==0) sign=0;
        else if(temp<0) sign=-1;
        else sign=1;

        for(int i=1;i<nums.length;i++){
            int n=nums[i];
            if(n==0){
                temp=0;
            }
            else if(sign==0){
                if(n<0){
                    sign=-1;
                    temp=n;
                }
                else{
                    sign=1;
                    temp=n;
                }
            }
            else if(sign < 0){
                if(n<0){
                    temp*=n;
                    sign=-1;
                }
                else{
                    temp=n;
                    sign=1;
                }
            }
            else{
                if(n<0){
                    temp=n;
                    sign=-1;
                }
                else{
                    temp*=n;
                    sign=1;
                }
            }
            ans= Math.max(temp,ans);
        }
        return ans;
    }
    
}
