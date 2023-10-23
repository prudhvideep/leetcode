class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        
        int mask = 1, c = 31;
        
        if((n & (~mask)) == 0)
            return true;
        
        while(c-- > 0){
            mask = mask << 1;
            if( (n & (~mask)) == 0)
                return true;
        }
        
        return false;
        
    }
}