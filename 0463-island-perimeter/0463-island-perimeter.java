class Solution {
    public int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int r = grid.length, c = grid[0].length, p = 0;
                  
        for(int i = 0;i < r;i++){
            int sum = 0;
            for(int j = 0;j < c;j++){
                
               if(grid[i][j] == 0) continue;
                
               sum+=4;
               
                if(i-1 >= 0 && grid[i-1][j] == 1)
                   sum-=1;
                
                if(i+1 < r && grid[i+1][j] == 1)
                   sum-=1;
                
                if(j-1 >= 0 && grid[i][j-1] == 1)
                    sum-=1;
                
                if(j+1 < c && grid[i][j+1] == 1)
                    sum-=1;
            }
            p+=sum;
        }
        
        return p;
    }
}