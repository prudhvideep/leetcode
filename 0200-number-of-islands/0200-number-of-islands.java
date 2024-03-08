class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, l = 0;
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                char t = grid[i][j];
                
                if(t == '1'){
                    dfs(i,j,r,c,grid);
                    l++;
                }  
            }
        }
        
        return l;
    }
    
    public void dfs(int i,int j, int r, int c, char[][] grid){
        if(grid[i][j] == '1'){
            grid[i][j] = 'v';
        } 
        
        if(i-1 >= 0 && grid[i-1][j] == '1')
            dfs(i-1,j,r,c,grid);
        
        if(i+1 < r && grid[i+1][j] == '1')
            dfs(i+1,j,r,c,grid);
        
        if(j-1 >= 0 && grid[i][j-1] == '1')
            dfs(i,j-1,r,c,grid);
        
        if(j+1 < c && grid[i][j+1] == '1')
            dfs(i,j+1,r,c,grid);
    }
}