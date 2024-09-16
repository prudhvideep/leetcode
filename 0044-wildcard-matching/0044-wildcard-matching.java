class Solution {
  public boolean isMatch(String s, String p) {
    int[][] dp = new int[s.length()][p.length()];

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        dp[i][j] = -1;
      }
    }

    if (helper(s.length() - 1, p.length() - 1, s, p, dp) == 1) {
      return true;
    }

    return false;
  }

  public int helper(int i, int j, String s, String p, int[][] dp) {

    if (i < 0 && j < 0)
      return 1;

    if (i >= 0 && j < 0)
      return 0;

    if (i < 0) {
      for(int k = 0;k <= j;k++){
        if(p.charAt(k) != '*')return 0;
      }

      return 1;
    }

    if(dp[i][j] != -1) return dp[i][j];

    if (p.charAt(j) == '?' || (p.charAt(j) == s.charAt(i))) {

      dp[i][j] = helper(i - 1, j - 1, s, p, dp);

      return dp[i][j];
    }

    if (p.charAt(j) == '*') {
      dp[i][j] =  helper(i,j-1,s,p,dp) | helper(i-1,j,s,p,dp);

      return dp[i][j];
    }

    return 0;
  }
}