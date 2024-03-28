class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0, h = 0, count = 0, pro = 1;
        
        while(h < n){
            pro = pro * nums[h];
            
            while(pro >= k && l <= h){
                pro = pro/nums[l];
                l++;
            }
            
            count+= (h-l+1);
            
            h++;
        }
        return count;
    }
}