class Solution {
    public int[] singleNumber(int[] nums) {
        int xy = 0, x = 0, y = 0, b = 1;
        
        for(int n : nums){
            xy ^= n;
        }
        
        while((xy & b) == 0)
            b = b << 1;
        
        for(int n : nums){
            if((n & b) == b)
                x ^= n;
            else
                y ^= n;
        }
        
        return new int[] {x,y};
        
    }
}