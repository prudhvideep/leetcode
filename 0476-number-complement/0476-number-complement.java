class Solution {
    public int findComplement(int num) {
        int mask = 0, n = num;

        while(n > 0){
            mask = (mask << 1) | 1;
            n = n >> 1;
        }

        return  (~num) & mask;
    }
}