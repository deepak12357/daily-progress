class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void solve(int[] nums, int n, int i, int target, ArrayList<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==n || target<0){
            return;
        }
        temp.add(nums[i]);
        solve(nums,n,i,target-nums[i],temp);
        temp.remove(temp.size()-1);
        solve(nums,n,i+1,target,temp);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
        ArrayList<Integer> temp = new ArrayList<>();
        
        solve(nums,nums.length,0,target,temp);
        return ans;
    }
}
