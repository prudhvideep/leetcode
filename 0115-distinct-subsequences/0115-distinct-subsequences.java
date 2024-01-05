class Solution {
    public int numDistinct(String s, String t) {
        int c = s.length(), r = t.length();
        
        int [][] dp = new int[r+1][c+1];
        
        for(int j = 0;j <= c;j++){
            dp[0][j] = 1;
        }
        
        for(int i = 1;i <= r;i++){
            for(int j = 1;j <= c;j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[r][c];
    }
}