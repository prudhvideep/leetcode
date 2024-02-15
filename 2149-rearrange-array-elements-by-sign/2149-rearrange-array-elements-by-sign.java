class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, pi = 0, ni = 0;
        
        int [] pa = new int[n/2];
        int [] na = new int[n/2];
        
        for(int i = 0;i < n;i++){
            if(nums[i] >= 0){
                pa[pi] = nums[i];
                pi++;
            }else{
                na[ni] = nums[i];
                ni++;
            }
        }
        
        pi = 0;ni = 0;
        for(int i = 0;i < n;i++){
            if(i%2 == 0){
                nums[i] = pa[pi];
                pi++;
            }else{
                nums[i] = na[ni];
                ni++;
            }
        }
        
        return nums;
    }
}