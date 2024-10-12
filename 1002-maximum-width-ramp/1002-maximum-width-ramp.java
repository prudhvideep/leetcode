class Solution {
  public int maxWidthRamp(int[] nums) {
    int n = nums.length;
    int[] maxVal = new int[n];

    maxVal[n - 1] = nums[n - 1];

    for(int i = n-2;i>= 0;i--){
      maxVal[i] = Math.max(nums[i],maxVal[i+1]);
    }

    int l = 0, r = 0,mw = 0;

    while(l < n && r < n){
      while((l <= r) && (r < n) && nums[l] <= maxVal[r]){
        mw = Math.max(mw,(r-l));
        r++;
      }   
      l++;
    }
    return mw;
  }
}