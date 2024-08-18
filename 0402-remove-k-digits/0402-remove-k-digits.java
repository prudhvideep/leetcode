class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack <> ();
        StringBuilder sb = new StringBuilder();

        st.push(num.charAt(0));

        for(int i = 1;i < num.length();i++){
            while(!st.isEmpty() && (k > 0) && (st.peek() > num.charAt(i))){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k-- > 0 && !st.isEmpty()){
          st.pop();
        }

        while(!st.isEmpty()){
            sb.insert(0,st.peek());
            st.pop();
        }

        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
          sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
}