class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>> paths = new ArrayList<>();
        
        ArrayList<Integer> path = new ArrayList<>();
        boolean []visited = new boolean[n];
        
        dfs(0,n,graph,path,paths);
        return paths;
    }
    
    void dfs(int u,int n,int [][]graph,ArrayList <Integer> path,List<List<Integer>> paths){
        path.add(u);
        for(int v : graph[u]){
            dfs(v,n,graph,path,paths);
        }
        if(u == n-1){
            paths.add(new ArrayList<>(path));   
        }
        path.remove(path.size()-1);
    }
}