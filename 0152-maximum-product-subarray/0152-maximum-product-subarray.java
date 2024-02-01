class Solution {
    public int maxProduct(int[] nums) {
        int max_here = nums[0], min_here = nums[0], max_global = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            int temp = Math.max(nums[i], Math.max((max_here*nums[i]),(min_here*nums[i])));
            min_here = Math.min(nums[i], Math.min((min_here*nums[i]),(max_here*nums[i])));
            max_here = temp;
            
            max_global = Math.max(max_global,Math.max(max_here,min_here));
        }
        
        return max_global;
}
}