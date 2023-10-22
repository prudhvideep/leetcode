class Solution {
    public int bitwiseComplement(int n) {
        
        int b = 1, res = 0;
        b = b << 30;
        
        while( (n & b) == 0 && b > 0)
            b = b >> 1;
        
        if(b == 0)
            return 1;
        
        int mask = 1;
        while(mask <= b){
            if((n & mask) == 0){
                res = res | mask;
            }
            mask = mask << 1;
        }
        return res;
    }
}