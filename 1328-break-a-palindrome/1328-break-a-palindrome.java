class Solution {
    public String breakPalindrome(String palindrome) {
        char [] chAr = palindrome.toCharArray();
        int len = palindrome.length();
        
        for(int i = 0;i < len/2;i++){
            char c = chAr[i];
            if(c != 'a'){
                chAr[i] = 'a';
                return String.valueOf(chAr);
            }
        }
        
        chAr[len-1] = 'b';
        return (len == 1)? "" : String.valueOf(chAr);   
    }
}