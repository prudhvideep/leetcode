class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> com = new ArrayList<>();
        
        genCom(1,n,k,com);
        
        return list;
    }
    
    public void genCom(int id, int n, int k, List <Integer> com){
        if(k == 0){
            list.add(new ArrayList<>(com));
            return;
        }
        
        for(int i = id; i <= n-k+1;i++){
            com.add(i);
            genCom(i+1,n,k-1,com);
            com.remove(com.size()-1);
        }
    }
}