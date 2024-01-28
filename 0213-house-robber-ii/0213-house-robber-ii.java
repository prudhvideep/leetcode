class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int n = nums.length;
        
        int [] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int [] nums2 = Arrays.copyOfRange(nums,1,n);
    
        
        return Math.max(dpSol(nums1),dpSol(nums2));
    }
    
    public int dpSol(int [] h){
        int n = h.length;
        int [] dp = new int[n+1];
        
        dp[0] = 0;dp[1] = h[0];
        
        for(int i = 2;i <= n;i++){
            dp[i] = Math.max(dp[i-1], h[i-1]+dp[i-2]);
        }
        
        return dp[n];
    }
}