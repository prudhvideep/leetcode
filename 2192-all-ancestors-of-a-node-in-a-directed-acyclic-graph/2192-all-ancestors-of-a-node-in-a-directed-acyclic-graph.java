class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n;i++){
            ans.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        
        //Build the adjacency list
        for(int [] a : edges) {
            adj.get(a[0]).add(a[1]);
        }
        
        for(int i = 0;i < n;i++){
            dfs(i,i,new boolean[n],adj,ans);
        }
        
        return ans;
    }
    
    public void dfs(int u, int anscestor,boolean []visited,ArrayList<ArrayList<Integer>> adj,List<List<Integer>> ans){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                ans.get(v).add(anscestor);
                dfs(v,anscestor,visited,adj,ans);
            }
        }
    }
}