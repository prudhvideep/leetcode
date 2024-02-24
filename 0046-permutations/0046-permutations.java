class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set <Integer> hs = new LinkedHashSet<>();
        
        genPerm(hs,nums,list);
        
        return list;
    }
    
    public void genPerm(Set <Integer> hs, int [] nums, List<List<Integer>> list){
        if(hs.size() == nums.length){
            list.add(new ArrayList<>(hs));
            return;
        }
        
        for(int i = 0;i < nums.length;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                genPerm(hs,nums,list);
                hs.remove(nums[i]);
            }
        }
    }
}