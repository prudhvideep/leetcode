public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        
        for(int i = 0;i < 32;i++){
            count += ((n & mask)/mask);
            mask = mask << 1;
        }
        return count;
    }
}