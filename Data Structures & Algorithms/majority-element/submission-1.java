class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, res = nums[0];
        for(int n : nums){
            if(n == res){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt==0){
                res=n;
                cnt=1;
            }
        }
        return res;
    }
}