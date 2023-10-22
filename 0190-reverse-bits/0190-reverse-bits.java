public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n == 0)
            return n;
        
        int rev = 0, mask = 1, c = 31,b = 0;
        b = n & mask;
        rev = rev | b;
        while(c-- > 0){
            rev = rev << 1;
            n = n >> 1;
            
            b = n & mask;
            rev = rev | b;
        }
        
        return rev;
    }
}