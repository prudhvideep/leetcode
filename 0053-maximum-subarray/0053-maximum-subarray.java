class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length;i++){
            if(curSum + nums[i] >= 0){
                curSum = Math.max(curSum+nums[i],nums[i]);
            }else{
                curSum = nums[i];
            }
            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }
}