class Solution {
    public int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        
        boolean visited[][] = new boolean [r][c];
              
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(i,j,visited,grid);
                }
            }
        }
        
        return perimeter;
    }
    
    public void dfs(int row,int col, boolean [][] visited, int [][] grid){
        visited[row][col] = true;
        int r = grid.length, c = grid[0].length;
        
        if(row-1 < 0 || (row-1 >= 0 && grid[row-1][col] == 0))perimeter++;
        
        if(row+1 >= r || (row+1 < r && grid[row+1][col] == 0))perimeter++;
        
        if(col-1 < 0 || (col-1 >= 0 && grid[row][col-1] == 0))perimeter++;
           
        if(col+1  >= c || (col+1 < c && grid[row][col+1] == 0))perimeter++;
           
        
        if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col] == 1)
           dfs(row-1,col,visited,grid);
           
        if(row+1 < r && !visited[row+1][col] && grid[row+1][col] == 1)
           dfs(row+1,col,visited,grid);
           
        if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1] == 1)
           dfs(row,col-1,visited,grid);
           
         if(col+1 < c && !visited[row][col+1] && grid[row][col+1] == 1)
           dfs(row,col+1,visited,grid);
    }
}