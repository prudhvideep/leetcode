class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List <Integer> l = new ArrayList<>();
        
        
        int counter[] = new int[graph.length];
        
        for(int i = 0;i < graph.length;i++){
            counter[i] = graph[i].length;
        }
        
        Queue <Integer> q = new LinkedList<>();
        
        for(int j = 0;j < counter.length;j++){
            if(counter[j] == 0)
                q.add(j);
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0;i < graph.length;i++){
            for(int j = 0;j < graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        
        //Start Bfs
        while(q.size() > 0){
            int temp = q.poll();
            
            for(int i = 0;i < adj.get(temp).size();i++){
                int v = adj.get(temp).get(i);
                counter[v]--;
                if(counter[v] == 0)
                    q.add(v);
            }
        }
        
        for(int i = 0;i < counter.length;i++){
            if(counter[i] == 0){
                l.add(i);
            }
        }
        return l;
    }
}