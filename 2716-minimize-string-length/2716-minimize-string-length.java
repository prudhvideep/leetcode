class Solution {
    public int minimizedStringLength(String s) {
        Set <Character> st = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        
        for(char c : s.toCharArray()){
            if(!st.contains(c)){
                st.add(c);
                sb.append(c);
            }
        }
        return sb.length();
    }
}