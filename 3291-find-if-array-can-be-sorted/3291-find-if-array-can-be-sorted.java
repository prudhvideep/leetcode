class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = -1;
        int curMin = nums[0];
        int curMax = nums[0];
        int bc = Integer.bitCount(nums[0]);

        for(int i = 1;i < nums.length;i++){
          if(bc == Integer.bitCount(nums[i])){
            curMin = Math.min(curMin,nums[i]);
            curMax = Math.max(curMax,nums[i]);
          }else{
            if(prevMax > curMin){
              return false;
            }

            prevMax = curMax;
            curMin = nums[i];
            curMax = nums[i];
            bc = Integer.bitCount(nums[i]);
          }
        }

        if(prevMax > curMin){
          return false;
        }

        return true;

    }
}