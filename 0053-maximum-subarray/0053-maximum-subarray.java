class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0,curSum = 0,maxEle = Integer.MIN_VALUE;
        boolean posSub = false;
        for(int  i = 0;i < nums.length;i++){
            if(curSum + nums[i] >= 0){
                posSub = true;
                curSum+=nums[i];
                maxSum = Math.max(curSum,maxSum);
            }else{
                curSum = 0;
            }
        } 
        if(!posSub){
            for(int  i = 0;i < nums.length;i++){
                maxEle = Math.max(maxEle,nums[i]);
            }
            return maxEle;
        }
        return maxSum;
    }
}