class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        long [] prefix = new long[n];
        prefix[0] = nums[0];
        
        for(int i = 1;i < n;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        long per = -1;
        int i = n-1;
        while(i > 0){
            if(prefix[i-1] > nums[i]){
                per = prefix[i];
                break;
            }
            i--;
        }
        return per;
    }
}