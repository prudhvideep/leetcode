class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
    
        int num1 = helper(nums,k);
        
        int num2 = helper(nums,k-1);
        
        return num1 - num2;
        
    }
    
    public int helper(int [] nums, int k){
        if(k <= 0)
            return 0;
        
        HashMap <Integer,Integer> hm = new HashMap<>();
        
        int n = nums.length;
        int count = 0, l = 0, h = 0;
        
        while(h < n){
            hm.put(nums[h],hm.getOrDefault(nums[h],0)+1);
            
            while(hm.size() > k){
                int c = hm.getOrDefault(nums[l],0);
                c = c-1;
                
                if(c <= 0)hm.remove(nums[l]);
                else hm.put(nums[l],c);
                
                l++;
            }
            
            count += (h-l+1);
            h++;
        }
        
        return count;
        
    }
}