class Solution {
    public int minimumLength(String s) {
        int l = 0, h = s.length()-1;
        
        while(l < h && (s.charAt(l) == s.charAt(h))){
            while( l < s.length()-1 && (s.charAt(l) == s.charAt(l+1))){
                l++;
            }
            
            while(h > 0 && (s.charAt(h) == s.charAt(h-1))){
                h--;
            }   
            l++;h--;
        }
        return ((h-l+1) < 0) ? 0 : (h-l+1);
    }
}