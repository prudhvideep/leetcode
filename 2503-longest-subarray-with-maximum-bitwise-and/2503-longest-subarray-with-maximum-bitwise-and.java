class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 1, s = 0,e = 0, mx = 0;
        HashMap <Integer,Integer> hm = new HashMap<>();

        while(e < nums.length){
          if(nums[e] >= mx){
            if(hm.containsKey(nums[e])){
              maxLen = Math.max(e-s+1,hm.get(nums[e]));
            }else{
              maxLen = e-s+1;
            }
            hm.put(nums[e],Math.max((e-s+1),hm.getOrDefault(nums[e],0)));
            mx = nums[e];
          }

          if(e+1 < nums.length && nums[e+1] == nums[e]){
            e++;
            continue;
          }else{
            e++;
            s = e;
          }
        }
        return maxLen;
    }
}