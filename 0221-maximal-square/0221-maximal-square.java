class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int [][] dp = new int[r][c];
        boolean oneExists = false;
        
        for(int i = 0;i < c;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
                oneExists = true;
            }
        }
        
        for(int i = 1;i < r;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                oneExists = true;
            }
        }
        
        int max = (oneExists == true)? 1 : 0;
        
        for(int i = 1;i < r;i++){
            for(int j = 1; j < c;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return max * max;
    }
}