class Solution {
    public List <String> list = new ArrayList<>(); 
    
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        char [] ch = {'(',')'};
        helper(0,n,ch,sb);
        
        return list;
        
    }
    
    public void helper(int id, int n, char [] ch, StringBuilder sb){
        if(id == (2*n)){
            if(isValid(sb.toString())){
                list.add(sb.toString());    
            }
            return;
        }
        
        for(char c : ch){
            sb.append(c);
            helper(id+1,n,ch,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public boolean isValid(String par){
        Stack<Character> st = new Stack();
        
        for(int i = 0;i < par.length();i++){
            char c = par.charAt(i);
            
            if(c == '('){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                
                st.pop();
            }
        }
        
        if(!st.isEmpty())
            return false;
        
        return true;
    }
}