class Solution {
    class Pair{
        public char e;
        public int c;
        Pair(char a, int b){
            this.e = a;
            this.c = b;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack <Pair> st = new Stack <> ();
        StringBuffer sb = new StringBuffer();
        
        for(char c : s.toCharArray()){
            if(st.size() == 0){st.push(new Pair(c,1));}
            else if(st.size() > 0){
                Pair temp = st.peek();
                if(temp.e != c){
                    st.push(new Pair(c,1));
                }else{
                    int count = temp.c;
                    count++;
                    
                    if(count == k){
                        st.pop();
                    }else if(count < k){
                        st.peek().c = count;
                    }
                }
            }
        }
        
        while(st.size() > 0){
            char c = st.peek().e;
            int ct = st.peek().c;
            while(ct-- > 0){
                sb.append(c);
            }
            st.pop();
        }
        
        return sb.reverse().toString();
    }
}