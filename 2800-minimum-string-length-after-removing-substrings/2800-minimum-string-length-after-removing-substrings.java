class Solution {
    public int minLength(String s) {
        Stack <Character> st = new Stack<>();

        for(char c : s.toCharArray()){
          if(st.isEmpty()){
            st.push(c);
            continue;
          }

          if(st.peek() == 'A' && c == 'B'){
            st.pop();
            continue;
          }

          if(st.peek() == 'C' && c == 'D'){
            st.pop();
            continue;
          }

          st.push(c);
        }

        return st.size();
    }
}