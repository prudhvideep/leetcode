class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack <> ();
        StringBuilder sb = new StringBuilder();

        for(char c : num.toCharArray()){
            while(!st.isEmpty() && (k > 0) && (st.peek() > c)){
                st.pop();
                k--;
            }
            st.push(c);
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