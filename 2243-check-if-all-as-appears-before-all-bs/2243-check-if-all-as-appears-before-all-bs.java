class Solution {
    public boolean checkString(String s) {
        Stack <Character> st = new Stack <> ();

        for(int i = 0;i < s.length();i++){
            if(!st.isEmpty() && (st.peek() == 'b') && (s.charAt(i) == 'a')){
                return false;
            }else{
                st.push(s.charAt(i));
            }
        }

        return true;
    }
}