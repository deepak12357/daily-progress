class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String x : operations){
            if(x.equals("C")){
                st.pop();
            }
            else if(x.equals("D")){
                int a = st.peek();
                st.push(a*2);
            }
            else if(x.equals("+")){
                int a = st.peek(); st.pop();
                int b = st.peek(); 
                st.push(a);
                st.push(a+b);
            }
            else{
                int val = Integer.parseInt(x);
                st.push(val);
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum+=st.peek();
            st.pop();
        }
        return sum;
    }
}