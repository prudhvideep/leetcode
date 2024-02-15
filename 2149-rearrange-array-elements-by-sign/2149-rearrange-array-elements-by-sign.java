class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, p = 0, ni = 1;
        int [] res = new int[n];
        
        for(int i = 0;i < n;i++){
            if(nums[i] >= 0){
                res[p] = nums[i];
                p+=2;
            }else{
                res[ni] = nums[i];
                ni+=2;
            }
        }
        
        return res;
    }
}