class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
        long ws = 0, ms = 0;
        Map <Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < k;i++){
          ws += nums[i];
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        if(map.size() == k){
          ms = Math.max(ws,ms);
        }

        for(int i = 1; i < nums.length-k+1;i++){
          ws += nums[i+k-1];
          ws -= nums[i-1];

          map.put(nums[i+k-1],map.getOrDefault(nums[i+k-1],0)+1);

          if(map.containsKey(nums[i-1])){
            if(map.get(nums[i-1]) > 1){
              map.put(nums[i-1],map.get(nums[i-1])-1);
            }else{
              map.remove(nums[i-1]);
            }
          }

          if(map.size() == k){
            ms = Math.max(ws,ms);
          }
        }

        return ms;
    }
}