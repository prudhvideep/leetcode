class Solution {
    public int minimumDeletions(String s) {
        Stack <Character> st = new Stack<>();
        int del = 0;
        for(int i = 0;i < s.length();i++){
            if(!st.isEmpty() && (st.peek() == 'b') && (s.charAt(i) == 'a')){
                del++;
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        return del;
    }
}