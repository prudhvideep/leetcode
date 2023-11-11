class Solution {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        
        int i = s.length()-1;
        
        while(i >= 0){
            int count = 0;
            while(i >= 0){
                if(s.charAt(i) == '*'){count++;i--;}
                else if(count > 0){count--;i--;}  
                else {break;}
            }
            if(i>=0){sb.append(s.charAt(i));}
            i--;
        }
        return sb.reverse().toString();
    }
}