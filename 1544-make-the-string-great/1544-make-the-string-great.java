class Solution {
    public String makeGood(String s) {
        Stack <Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0;i < s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                char c = st.peek();
                if(Math.abs(c-s.charAt(i)) == 32){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        
        while(!st.isEmpty()){
            sb.insert(0,st.peek());
            st.pop();
        }
        
        return sb.toString();
    }
}