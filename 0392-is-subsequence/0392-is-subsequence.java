class Solution {
    public boolean isSubsequence(String s, String t) {
        int r = s.length(), c = t.length();
        
        if(r > c) return false;
        if(r == 0 && c == 0) return true;
        if((r != 0 && c == 0)) return false;
        
        boolean dp [][] = new boolean [r+1][c+1];
        
        for(int j = 0;j <= c; j++){
            dp[0][j] = true;
        }
        
        for(int i = 1;i <= r;i++){
            dp[i][0] = false;
        }
        
        for(int i = 1; i <= r;i++){
            for(int j = 1; j <= c;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[r][c];
    }
}