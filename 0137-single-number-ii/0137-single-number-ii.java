class Solution {
    public int singleNumber(int[] nums) {
        int res = 0,mask,b;
        for(int i = 0;i < 32;i++){
            mask = (1 << i);
            b=0;
            for(int j = 0;j < nums.length;j++){
                b+= (nums[j] & mask)/mask;
            }
            res = res | ((b%3) << i);
        }
        return res;
    }
}