class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> per = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        genPer(nums.length,hm,per,list);
        
        return list;
    }
    
    public void genPer(int n, HashMap<Integer,Integer> hm,List <Integer> per,List<List<Integer>> list){
        if(per.size() == n){
            list.add(new ArrayList<>(per));
        }
        
        for(int i : hm.keySet()){
            if(hm.get(i) > 0){
                per.add(i);
                hm.put(i,hm.get(i)-1);
                genPer(n,hm,per,list);
                per.remove(per.size()-1);
                hm.put(i,hm.get(i)+1);
            }
        }
    }
}