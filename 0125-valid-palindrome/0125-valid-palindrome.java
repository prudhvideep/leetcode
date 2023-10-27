class Solution {    
    public boolean isPalindrome(String s) {
        int l = 0, h = s.length()-1;
        
        while(l <= h){
            Character a = s.charAt(l);
            Character b = s.charAt(h);
            
            if(!Character.isLetterOrDigit(a)){
                 l++;
                continue;   
            }
            
            if(!Character.isLetterOrDigit(b)){
                h--;
                continue; 
            }
            
            if(Character.toLowerCase(a) != Character.toLowerCase(b))
                return false;
            l++;h--;
        }
        return true;
    }
}