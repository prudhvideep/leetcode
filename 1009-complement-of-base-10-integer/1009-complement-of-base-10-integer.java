class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        
        int mask = 0, num = n;
        
        while(num > 0){
            mask = mask << 1 | 1;
            num = num >> 1;
        }
        
        return (~n) & mask;
    }
}