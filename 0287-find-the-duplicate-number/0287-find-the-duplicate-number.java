class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length;i++){
            int id = Math.abs(nums[i])-1;
                        
            if(nums[id] < 0)
                return id+1;
            
            nums[id] = -1 * nums[id];
        }
        
        return -1;
    }
}