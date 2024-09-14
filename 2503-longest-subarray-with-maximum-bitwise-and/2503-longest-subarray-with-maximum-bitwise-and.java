class Solution {
    public int longestSubarray(int[] nums) {
        int maxE = 0;

        for(int i : nums){
          maxE = Math.max(maxE,i);
        }
        
        int count = 0,maxCount = 0;
        for(int i = 0;i < nums.length;i++){
          if(nums[i] == maxE){
            count++;
            maxCount = Math.max(count,maxCount);
          }else{
            count = 0;
          }
        }

        return maxCount;
    }
}