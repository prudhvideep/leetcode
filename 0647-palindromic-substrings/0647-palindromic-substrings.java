class Solution {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();        
        //Odd number palindromes
        for(int i = 0;i < n;i++){
            int j = i;
            int k = i;
            
            while(j>=0 && k<n && (s.charAt(j) == s.charAt(k))){
                count++;
                j--;
                k++;
            }
        }
        
        //Even number palindromes
        for(int i = 0;i < n;i++){
            int j = i;
            int k = i+1;
            
            while(j>=0 && k < n && (s.charAt(j) == s.charAt(k))){
                count++;
                j--;
                k++;
            }
        }
        
        return count;
    }
}