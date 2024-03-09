class Solution {
    public int time = -1, or = 0,r = 0,c = 0;
    
    public int orangesRotting(int[][] grid) {
        r = grid.length; c = grid[0].length;
        int maxTime = Integer.MIN_VALUE;
        int fo = getFreshOrangeCount(grid);
        int dist[][] = new int[r][c];
        initDist(dist);
        
        if(fo == 0)
            return fo;
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 2){
                    //or = 0;
                    //dfs(i,j,grid,new int[r][c]);
                    dist[i][j] = 0;
                    bfs(i,j,grid,new int[r][c],dist);   
                }
            }
        }
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1){
                    //System.out.println(dist[i][j]);
                    maxTime = Math.max(maxTime,dist[i][j]);
                }
            }
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
    
    public int getFreshOrangeCount(int[][] grid){
        int fc = 0;
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1){
                    fc++;
                }   
            }
        }
        return fc;
    }
    
    public void dfs(int i, int j, int [][] grid,int [][] visited){
        if(visited[i][j] == 1)
            return;
        
        visited[i][j] = 1;
        
        if(grid[i][j] == 1){
           or++; 
        }
        
        if(i-1 >= 0 && visited[i-1][j] == 0 && grid[i-1][j] == 1) {dfs(i-1,j,grid,visited);}
        if(i+1 < r && visited[i+1][j] == 0 && grid[i+1][j] == 1) {dfs(i+1,j,grid,visited);}
        if(j-1 >= 0 && visited[i][j-1] == 0 && grid[i][j-1] == 1) {dfs(i,j-1,grid,visited);}
        if(j+1 < c && visited[i][j+1] == 0 && grid[i][j+1] == 1) {dfs(i,j+1,grid,visited);}        
    }
    
    public void bfs(int i, int j, int [][] grid,int [][] visited, int[][] dist){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                pair p = q.poll();
                int a = p.i;
                int b = p.j;
                if(a-1 >= 0 && visited[a-1][b] == 0 && grid[a-1][b] == 1) 
                { 
                    visited[a-1][b] = 1;
                    dist[a-1][b] = Math.min(dist[a-1][b],1+dist[a][b]);
                    q.add(new pair(a-1,b));
                }
                if(a+1 < r && visited[a+1][b] == 0 && grid[a+1][b] == 1) 
                {
                    visited[a+1][b] = 1;
                    dist[a+1][b] = Math.min(dist[a+1][b],1+dist[a][b]);
                    q.add(new pair(a+1,b));
                }
                if(b-1 >= 0 && visited[a][b-1] == 0 && grid[a][b-1] == 1) 
                {
                    visited[a][b-1] = 1;
                    dist[a][b-1] = Math.min(dist[a][b-1],1+dist[a][b]);
                    q.add(new pair(a,b-1));
                }
                if(b+1 < c && visited[a][b+1] == 0 && grid[a][b+1] == 1)
                {
                    visited[a][b+1] = 1;
                    dist[a][b+1] = Math.min(dist[a][b+1],1+dist[a][b]);
                    q.add(new pair(a,b+1));
                }
                n--;
            }
            time++;
        }
    }
    
    class pair{
        public int i;
        public int j;
        public pair(int a,int b){
            this.i = a;
            this.j = b;
        }
    }
}