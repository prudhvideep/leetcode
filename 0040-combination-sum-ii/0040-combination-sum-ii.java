class Solution {
    public Set<List<Integer>> s = new HashSet<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i : candidates){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        genComSum(hm,l,target);
        List<List<Integer>> list = new ArrayList<>(s);
        return list;
    }
    
    public void genComSum(HashMap<Integer,Integer> hm, List<Integer> l,int target){
        //System.out.println(l + " Target : " + target);
        if(target < 0){
          return;  
        }
        
        if(target == 0){
            
            List<Integer> lis = new ArrayList<>(l);
            Collections.sort(lis);
            s.add(lis);
            return;
        }
        
        for(Map.Entry<Integer,Integer> me : hm.entrySet()){
           
           int key = me.getKey();
            if(hm.get(key) == 0){
                continue;                
            }
            
            
           hm.put(key,hm.getOrDefault(key,0)-1);
           l.add(key);
            
            genComSum(hm,l,target-key);
            l.remove(l.size()-1);
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
    }
}