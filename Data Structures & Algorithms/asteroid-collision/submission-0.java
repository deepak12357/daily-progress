class Solution {
    public int[] asteroidCollision(int[] as) {
        Stack<Integer> st = new Stack<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<as.length;i++){
            if(st.isEmpty()){
                if(as[i]>0)
                    st.push(as[i]);
                else
                    l.add(as[i]);
            }
            else{
                if(as[i]>0){
                    st.push(as[i]);
                }
                else{
                    while(!st.isEmpty() && st.peek()<=as[i]*-1){
                        if(st.peek()==as[i]*-1){
                            st.pop();
                            break;
                        }
                        else{
                            if(st.size()==1)
                                l.add(as[i]);
                            st.pop();
                        }
                    }
                }
            }
        }
        List<Integer> l2 = new ArrayList<Integer>();
        while(!st.isEmpty()){
            l2.add(st.pop());
        }
        Collections.reverse(l2);
        l.addAll(l2);

        int[] arr = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            arr[i] = l.get(i);
        }
        return arr;
    }
}