class Solution {
    public String removeDuplicates(String str) {
        Stack <Character> s = new Stack <> ();
        StringBuffer sb = new StringBuffer();
        
        for(char c : str.toCharArray()){
            if(s.size() == 0 || (s.size() > 0 && (s.peek() != c))){s.push(c);}
            else if(s.peek() == c){s.pop();}
        }
        while(s.size() > 0){
            sb.append(s.peek());
            s.pop();
        }
        return sb.reverse().toString();
    }
}