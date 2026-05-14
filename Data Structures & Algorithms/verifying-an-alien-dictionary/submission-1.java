class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for(int i=0;i<26;i++){
            ord[(int)order.charAt(i)-'a'] = i;
        }
        
        for(int i=0; i<words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int j=0 ; 
            for(;j<w1.length(); j++){
                if(j==w2.length()){
                    return false;
                }
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1!=c2){
                    if(ord[c1-'a']>ord[c2-'a']){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}