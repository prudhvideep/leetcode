class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        
        dfs(0,visited,rooms);
        
        for(boolean v : visited)
            if(!v)
                return false;
        
        return true;
    }
    
    public void dfs(int u, boolean [] visited,List<List<Integer>> rooms){
        visited[u] = true;
        
        for(int v : rooms.get(u)){
            if(!visited[v])
                dfs(v,visited,rooms);
        }
    }
}