class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(n < k)
            return list;
        
        List<Integer> com = new ArrayList<>();
        int [] nums = new int[n];
        for(int i = 1; i <= n;i++){
            nums[i-1] = i;
        }
        
        genCom(0,k,nums,com,list);
        
        return list;
    }
    
    public void genCom(int id,int k, int [] nums, List <Integer> com, List<List<Integer>> list){
        if(com.size() == k){
            list.add(new ArrayList<>(com));
            return;
        }
        
        for(int i = id;i < nums.length;i++){
            com.add(nums[i]);
            genCom(i+1,k,nums,com,list);
            com.remove(com.size()-1);
        }
    }
}