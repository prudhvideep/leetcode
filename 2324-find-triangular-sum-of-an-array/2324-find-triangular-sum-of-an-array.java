class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int l = 0, h = 1, LIMIT = n-1;

        if(n == 1) return nums[0];

        while(LIMIT > 0) {
          for(int i = 0;i < LIMIT;i++) {
            nums[i] = (nums[i] + nums[i+1])%10;
          }

          LIMIT--;
        } 

        return nums[0];
    }
}