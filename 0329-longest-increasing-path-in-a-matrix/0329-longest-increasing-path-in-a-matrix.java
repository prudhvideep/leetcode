class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    int r = matrix.length, c = matrix[0].length;
    int dp[][] = new int[r][c];
    boolean visited[][] = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
          if (dp[i - 1][j] == 0) {
            dp[i - 1][j] = dfs(i - 1, j, visited, matrix, dp);
          }
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j]);
        }

        if (i + 1 < r && matrix[i + 1][j] > matrix[i][j]) {
          if (dp[i + 1][j] == 0) {

            dp[i + 1][j] = dfs(i + 1, j, visited, matrix, dp);
          }
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j]);
        }

        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
          if (dp[i][j - 1] == 0) {

            dp[i][j - 1] = dfs(i, j - 1, visited, matrix, dp);
          }
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j - 1]);
        }

        if (j + 1 < c && matrix[i][j + 1] > matrix[i][j]) {
          if (dp[i][j + 1] == 0) {
            dp[i][j + 1] = dfs(i, j + 1, visited, matrix, dp);
          }
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
        }

        dp[i][j] = Math.max(dp[i][j], 1);
      }
    }

    int maxE = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        maxE = Math.max(maxE, dp[i][j]);
      }
    }

    return maxE;
  }

  public int dfs(int i, int j, boolean[][] visited, int[][] matrix, int [][] dp) {
    if (visited[i][j] == true)
      return 0;

    visited[i][j] = true;

    int top = 0, bottom = 0, left = 0, right = 0;
    if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
      if(dp[i-1][j] == 0){
        dp[i-1][j] = dfs(i - 1, j, visited, matrix, dp);
      }
      top = dp[i-1][j];
    }

    if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
      if(dp[i+1][j] == 0){
        dp[i+1][j] = dfs(i + 1, j, visited, matrix, dp);
      }
      bottom =  dp[i+1][j];
    }

    if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
      if(dp[i][j-1] == 0){
        dp[i][j-1] = dfs(i, j - 1, visited, matrix, dp);
      }
      left = dp[i][j-1];
    }

    if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
      if(dp[i][j+1] == 0){
        dp[i][j+1] = dfs(i, j + 1, visited, matrix, dp);
      }
      right = dp[i][j+1];
    }


    int res = 1+Math.max(Math.max(top, bottom), Math.max(left, right));
    visited[i][j] = false;
    return res;

  }
}