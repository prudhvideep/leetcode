class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1, mid;

        while(l <= h){
            mid = l + (h-l)/2;
            if(nums[mid] == target){
                return true;
            }

            if((nums[mid] == nums[h]) && (nums[l] == nums[h])){
                l++;h--;
                continue;
            }else if(nums[mid] >= nums[l]){
                if(target < nums[mid] && target >= nums[l]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }else{

                if(target > nums[mid] && target <= nums[h]){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return false;
    }
}