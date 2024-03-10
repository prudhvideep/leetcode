class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxE = Integer.MIN_VALUE, minE = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                maxE = Math.max(maxE,nums[i]);
                minE = Math.min(minE,nums[i]);
            }else{
                nums[i] = 1;
            }
        }
        
        if(minE > 1 || (minE <= 0 && maxE <= 0))
            return 1;
        
        for(int i : nums){
            i = Math.abs(i);
            if((i >= 1 && i <= n) && nums[i-1] > 0){
                nums[i-1] = -1 * nums[i-1];
            }
        }
        
        for(int i = 0;i < n;i++){
            if(!(nums[i] < 0)){
                return i+1;
            }
        }
    
        return  n+1;
    }
}