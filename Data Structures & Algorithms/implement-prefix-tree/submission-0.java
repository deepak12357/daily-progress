class PrefixTree {
    class Trie{
        Trie[] child = new Trie[26];
        boolean end = false;
        char ch;
        public Trie(char ch){
            this.ch=ch;
            for(Trie i : child){
                i=null;
            }
        }
    }
    Trie root = null;
    public PrefixTree() {
        root = new Trie('*');
    }

    public void insert(String word) {
        Trie temp = root;
        for(char c : word.toCharArray()){
            int idx = (int)c-(int)'a';
            // System.out.println(word+ " , " + idx);
            if(temp.child[idx]==null){
                Trie temp1 = new Trie(c);
                temp.child[idx]=temp1;
                temp=temp1;
            }
            else{
                temp=temp.child[idx];
            }
        }
        temp.end = true;
    }

    public boolean commonSearch(String word, boolean checkPrefix){
        Trie temp = root;
        for(char c : word.toCharArray()){
            int idx = (int)c-(int)'a';
            if(temp.child[idx]==null){
                System.out.println(word+" , "+idx);
                return false;
            }
            temp=temp.child[idx];
        }
        return checkPrefix || temp.end;
    }

    public boolean search(String word) {
        return commonSearch(word,false);
    }

    public boolean startsWith(String prefix) {
        return commonSearch(prefix,true);
    }
}
