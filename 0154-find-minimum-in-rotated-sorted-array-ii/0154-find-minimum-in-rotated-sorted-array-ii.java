class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length-1, mid, minE = Integer.MAX_VALUE;

        while(l <= h){
            mid = l + (h-l)/2;
            
            minE = Math.min(minE,nums[mid]);

            if(nums[mid] == nums[h]){
                while( (l < h) && (nums[l] == nums[mid]) && nums[h] == nums[mid]){
                    l++;h--;
                }
                if(nums[l] < minE){
                    h = mid-1;
                }else if(nums[h] < minE){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }else if(nums[mid] > nums[h]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return minE;
    }
}