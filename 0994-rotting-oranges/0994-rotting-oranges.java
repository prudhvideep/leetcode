class Solution {
    public int time = -1,r = 0,c = 0;
    
    public int orangesRotting(int[][] grid) {
        r = grid.length; c = grid[0].length;
        int maxTime = Integer.MIN_VALUE;
        boolean hasFreshOrg = false;
        
        int dist[][] = new int[r][c];
        initDist(dist);
        int visited[][] = new int[r][c];
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 2){
                    dist[i][j] = 0;
                    initVisited(visited);
                    bfs(i,j,grid,visited,dist);   
                }
            }
        }
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1){
                    hasFreshOrg = true;
                    maxTime = Math.max(maxTime,dist[i][j]);
                }
            }
        }
        
        if(!hasFreshOrg){
            return 0;
        }
        return (maxTime == Integer.MAX_VALUE)?-1:maxTime;
    }

    public void initDist(int [][] dist){
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    
    public void initVisited(int [][] visited){
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                visited[i][j] = 0;
            }
        }
    }
    
    public void bfs(int i, int j, int [][] grid,int [][] visited, int[][] dist){
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                int [] p = q.poll();
                int a = p[0];
                int b = p[1];
                if(a-1 >= 0 && visited[a-1][b] == 0 && grid[a-1][b] == 1) 
                { 
                    visited[a-1][b] = 1;
                    dist[a-1][b] = Math.min(dist[a-1][b],1+dist[a][b]);
                    q.add(new int[] {a-1,b});
                }
                if(a+1 < r && visited[a+1][b] == 0 && grid[a+1][b] == 1) 
                {
                    visited[a+1][b] = 1;
                    dist[a+1][b] = Math.min(dist[a+1][b],1+dist[a][b]);
                    q.add(new int[] {a+1,b});
                }
                if(b-1 >= 0 && visited[a][b-1] == 0 && grid[a][b-1] == 1) 
                {
                    visited[a][b-1] = 1;
                    dist[a][b-1] = Math.min(dist[a][b-1],1+dist[a][b]);
                    q.add(new int[] {a,b-1});
                }
                if(b+1 < c && visited[a][b+1] == 0 && grid[a][b+1] == 1)
                {
                    visited[a][b+1] = 1;
                    dist[a][b+1] = Math.min(dist[a][b+1],1+dist[a][b]);
                    q.add(new int[] {a,b+1});
                }
                n--;
            }
            time++;
        }
    }
}