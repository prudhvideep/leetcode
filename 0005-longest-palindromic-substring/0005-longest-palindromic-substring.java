class Solution {
    
    public String longestPalindrome(String s) {
        int maxOddLen = 1, maxEvenLen = 0;
        int oddStId = 0, oddEnId = 0, evenStId = 0, evenEnId = 0;
        
        for(int i = 0;i < s.length()-1;i++){
            
            int l = i-1, h = i+1, len = 1;
            
            while((l >= 0 && h < s.length()) && (s.charAt(l) == s.charAt(h))){
                len+=2;
                if(len > maxOddLen){
                    maxOddLen = len;
                    oddStId = l;
                    oddEnId = h;
                }
                l--;h++;
            }
            
            l = i; h = i+1; len = 0;
            
            while((l >= 0 && h < s.length()) && (s.charAt(l) == s.charAt(h))){
                len+=2;
                if(len > maxEvenLen){
                    maxEvenLen = len;
                    evenStId = l;
                    evenEnId = h;
                }
                l--;h++;
            }
        }
                  
        if(maxOddLen > maxEvenLen)
            return s.substring(oddStId,oddEnId+1);
        
        return s.substring(evenStId,evenEnId+1);
    }
}