class Solution {
    boolean ans = false;
    public boolean solve(String s, List<String> wordDict, String temp, HashMap<String,Boolean> dp){
        if(temp.equals(s)){
            return true;
        }
        if(temp.length()>=s.length()){
            return false;
        }
        if(dp.get(temp)!=null){
            return false;
        }
        String temp1="";
        for(String word : wordDict){
            if(ans) return ans;
            temp1=temp+word;
            ans = solve(s,wordDict,temp1,dp);
        }
        dp.put(temp,ans);
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> dp = new HashMap<>();
        return solve(s,wordDict,"",dp);
    }
}
