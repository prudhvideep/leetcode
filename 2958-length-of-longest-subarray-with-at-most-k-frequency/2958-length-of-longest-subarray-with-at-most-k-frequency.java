class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap <Integer,Integer> hm = new HashMap<>();
        
        int l = 0, h = 0, maxLen = Integer.MIN_VALUE, n = nums.length, c = 0,key = 0;
        
        while(h < n){
            
            hm.put(nums[h],hm.getOrDefault(nums[h],0)+1);
            while((hm.get(nums[h]) > k) && (l <= h)){
                key = nums[l];
                c = hm.get(key);
                hm.put(key, ((c-1) >= 0 ? c-1 : 0));
                l++;
            }
            
            maxLen = Math.max(maxLen,(h-l+1));
            h++;
        }
        
        return maxLen;
    }
}