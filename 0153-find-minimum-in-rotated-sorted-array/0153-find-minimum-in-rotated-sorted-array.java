class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length-1, mid;

        while(l < h){
            mid = l + (h-l)/2;

            if(((mid > 0) && (nums[mid-1] > nums[mid]))
                && ((mid < nums.length-1) && (nums[mid+1] > nums[mid]))){
                    return nums[mid];
            }else if(nums[mid] < nums[h]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }

        return nums[l];
    }
}