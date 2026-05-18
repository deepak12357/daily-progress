class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt=0;
        int n=nums.length;
        int j=n-1;
        for(int i=0;i<=j;i++){
            while(nums[j]==val){
                j--;
                cnt++;
            }
            if(nums[i]==val){
                swap(nums,i,j);
                j--;
                cnt++;
            }
        }
        return n-cnt;
    }
    void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}