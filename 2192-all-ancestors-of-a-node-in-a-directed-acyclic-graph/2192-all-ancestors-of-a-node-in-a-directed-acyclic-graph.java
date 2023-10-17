class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            al.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i < edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        
        for(int i = 0;i < n;i++){
            dfs(i,i,new boolean[n],adj,al);
        }

        return al;
    }
    
    public void dfs(int u,int parent, boolean [] visited, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> al){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(visited[v])
                continue;
            al.get(v).add(parent);
            dfs(v,parent,visited,adj,al);
        }
    }
    
}