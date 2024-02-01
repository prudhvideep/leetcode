class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, maxVal = 0, n = nums.length, f = 0;
        for(int i : nums)
            sum+=i;
        
        for(int i = 0;i < n ; i++){
            f += i * nums[i];
        }
        
        maxVal = f;
        for(int i = 1;i < n; i++){
            f = f + sum - (n * nums[n-i]);
            maxVal = Math.max(maxVal,f);
        }
        
        return maxVal;
            
    }
}