class Solution {
    public void dfs(int u, List<List<Integer>> adj, boolean [] visited){
        if(visited[u])
            return;

        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(v,adj,visited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n ;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean visited [] = new boolean[n];
        Arrays.fill(visited,false);

        int comp = 0;
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                comp++;
                dfs(i,adjList,visited);
            }
        }

        return n - comp;

    }
}