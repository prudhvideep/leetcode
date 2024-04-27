class Solution {
    public int minFallingPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        
        int [][] dp = new int[r][c];
        
        for(int i = 0;i < c;i++){
            dp[0][i] = grid[0][i];
        }
        
        for(int i = 1;i < r;i++){
            for(int j = 0; j < c;j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0;k < c;k++){
                    if(j == k)
                        continue;
                    
                    min = Math.min(min,dp[i-1][k]);
                }
                
                dp[i][j] = min+grid[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0;j < c;j++){
            min = Math.min(min,dp[r-1][j]);
        }
        
        return min;
    }
}