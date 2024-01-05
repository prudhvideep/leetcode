class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        
        
        int id = 0;
        while(id < palindrome.length() && palindrome.charAt(id) == 'a'){
            id++;
        }
        
        StringBuffer sb = new StringBuffer(palindrome);
        
        if(id == palindrome.length()){
            sb.setCharAt(id-1,'b');
            return sb.toString();
        }
        
        
        if((id-1 >= 0 && sb.charAt(id-1) == 'a') && (id+1 < sb.length() && sb.charAt(id+1) == 'a')){
            sb.setCharAt(sb.length()-1,'b');
            return sb.toString();
        }
    
        sb.setCharAt(id,'a');
        
        return sb.toString();
    }
}