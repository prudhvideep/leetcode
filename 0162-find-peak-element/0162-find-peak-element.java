class Solution {
  public int findPeakElement(int[] nums) {
        int l = 0,h = nums.length-1,n = nums.length;

        if(nums.length == 1){
          return 0;
        }

        if(nums[0] > nums[1]){
          System.out.println("Isndie");
          return 0;
        }

        if(nums[n-1] > nums[n-2]){
          return n-1;
        }
        
        int mid =0;
        while(l <= h){
            mid = l + (h-l)/2;

            if(mid-1 >= 0 && mid+1 < n && (nums[mid-1] < nums[mid]) && (nums[mid+1] < nums[mid])){
              return mid;
            }else if(mid-1 >= 0 && nums[mid-1] > nums[mid]){
              h = mid-1;
            }else{
              l = mid+1;
            }
        }
        return mid;
    }
}