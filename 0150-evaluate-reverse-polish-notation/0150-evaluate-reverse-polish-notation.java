class Solution {
    boolean isOperator(String token){
        if(token.length() == 1){
            if(token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*' || token.charAt(0) == '/')
                return true;
        }
        return false;
    }
    
    int performOp(int x,int y, String op){
        if(op.charAt(0) == '+')
            return x+y;
        if(op.charAt(0) == '-')
            return (y-x);
        if(op.charAt(0) == '*')
            return x*y;
        if(x == 0 || y == 0)
            return 0;
        return (y/x);
    }
    
    public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack<>();
        
        for(int i = 0;i < tokens.length;i++){
            String temp = tokens[i];
            if(!isOperator(temp)){
                s.push(Integer.parseInt(temp));
            }else{
                
                int x = s.peek();
                s.pop();
                
                int y = s.peek();
                s.pop();
                
                int r = performOp(x,y,temp);
                s.push(r);
            }
        }
        return s.peek();
    }
}