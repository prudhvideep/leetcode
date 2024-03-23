class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = Integer.MIN_VALUE,count = 0;
        HashMap <Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0)
                count--;
            
            if(nums[i] == 1)
                count++;
            
            if(hm.containsKey(count)){
                maxLen = Math.max(maxLen, i - hm.get(count));
            }else{
                hm.put(count,i);
            }
        }
        
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}