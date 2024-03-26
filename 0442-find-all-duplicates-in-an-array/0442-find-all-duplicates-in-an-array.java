class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> list = new ArrayList<>();
        
        for(int i = 0;i < nums.length;i++){
            int id = Math.abs(nums[i])-1;
            
            if(nums[id] < 0){
                list.add(id+1);
                continue;
            }
            nums[id] = -1 * nums[id];
        }
        return list;
    }
}