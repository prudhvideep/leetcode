class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0;i < n;i++){
            adjList.add(new ArrayList<>());
        }
        
        boolean [] visited = new boolean[n];
        
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            
        }
        
        dfs(source,destination,adjList,visited);
        
        if(visited[destination])
            return true;
        
        return false;
        
    }
    
    public void dfs(int s, int d,List<List<Integer>> adjList,boolean [] visited){
        
        visited[s] = true;
        
        if(s == d)return;
        
        for(int i = 0; i < adjList.get(s).size();i++){
            int u = adjList.get(s).get(i);
            if(!visited[u]){
                dfs(u,d,adjList,visited);
            }
        }
    }
}