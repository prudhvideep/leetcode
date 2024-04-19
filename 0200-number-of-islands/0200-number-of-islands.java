class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        
        boolean visited [][] = new boolean[r][c];
        int count = 0;
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(i,j,visited,grid);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int row,int col,boolean [][] visited, char [][] grid){
        visited[row][col] = true;
        
        if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col] == '1')dfs(row-1,col,visited,grid);
        
        if(row+1 < grid.length && !visited[row+1][col]  && grid[row+1][col] == '1')dfs(row+1,col,visited,grid);
        
        if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1] == '1')dfs(row,col-1,visited,grid);
        
        if(col+1 < grid[0].length && !visited[row][col+1] && grid[row][col+1] == '1' )dfs(row,col+1,visited,grid);
        
        
    }
}