class Solution {
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> can = new ArrayList<>();
        checkSum(0,can,target,candidates);
        return list;
    }
    
    public void checkSum(int id, List <Integer> can,int target,int [] candidates){
        if(target < 0) return;
        if(target == 0){
            list.add(new ArrayList<>(can));
            return;
        }
        
        for(int i = id;i < candidates.length;i++){
            can.add(candidates[i]);
            checkSum(i,can,target-candidates[i],candidates);
            can.remove(can.size()-1);
        }
    }
}