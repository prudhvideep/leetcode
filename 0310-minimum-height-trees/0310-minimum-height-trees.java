class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List <Integer> ans = new ArrayList<>();
        
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for(int  i = 0;i < n;i++){
            adj.add(new HashSet<>());
        }
        
        for(int [] a : edges){    
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        
        ArrayList <Integer> l = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(adj.get(i).size() == 1)
                l.add(i);
        }
        
        while(n > 2){
            n = n-l.size();
            ArrayList<Integer> nl = new ArrayList<>();
            for(int v : l){
                Integer nei = adj.get(v).iterator().next();
                adj.get(nei).remove(v);
                if(adj.get(nei).size() == 1)
                    nl.add(nei);
            }
            l = nl;
        }
        return l;
    }
}


