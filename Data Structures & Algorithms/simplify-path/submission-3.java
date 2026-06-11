class Solution {
    Stack<String> st = new Stack<>();
    public void condition(String temp){
        if(temp.equals("..")){
            if(st.size()>=1)
                st.pop();
        }
        else if(temp.length()>2){
            st.push(temp);
        }   
    }
    public String simplifyPath(String path) {
        
        char lastChar = path.charAt(0);
        int n= path.length();
        String word = "";
        for(int i=0;i<n;i++){
            if(path.charAt(i)=='.'){
                word=path.charAt(i)+word;
                lastChar = '.';
            }
            else if(path.charAt(i)=='/'){
                if(lastChar!='/'){
                    if(lastChar == 'a'){
                        st.push(word);
                    }
                    else{
                        condition(word);
                    }
                    word = "";
                }
                lastChar = '/';
            }
            else{
                word=path.charAt(i)+word;
                lastChar = 'a';
            }
        }
        if(lastChar == '.'){
            condition(word);
        }
        else if(lastChar == 'a'){
            st.push(word);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            String front = st.peek();
            System.out.println(front);
            st.pop();
            sb.append(front);
            sb.append("/");
        }
        String ans = sb.reverse().toString();
        if(ans.length()==0){
            return "/";
        }
        return ans;
    }
}