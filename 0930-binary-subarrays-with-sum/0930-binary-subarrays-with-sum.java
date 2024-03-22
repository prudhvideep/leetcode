class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {        
        return helper(nums,goal) - helper(nums,goal-1);
    }
    
    public int helper(int [] nums,int goal){
        if(goal < 0) return 0;
        
        int s = 0, curSum = 0,count = 0;
        
        for(int e = 0;e < nums.length;e++){
            curSum += nums[e];
            
            while(curSum > goal){
                curSum = curSum - nums[s];
                s++;
            }   
            
            count+= (e-s+1);
               
        }
        
        return count;
    }
}