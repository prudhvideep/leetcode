class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int l = nums[0] == 0 ? 1 : nums[0], r = nums[n-1] == 0 ? 1 : nums[n-1];
        int maxProd = Math.max(nums[0],nums[n-1]);
        
        for(int i = 1;i < n;i++){
            l = nums[i]*l;
            r = nums[n-i-1]*r;
            maxProd = Math.max(maxProd,Math.max(l,r));
            
            if(nums[i] == 0) l = 1;
            if(nums[n-i-1] == 0) r =1;
        }
        
        return maxProd;
    }
}