class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        if(n == 1)
            return 1;
        
        int [] dp = new int[26];
        int res = 0;
        
        for(int i = 0;i < n;i++){
            int c = s.charAt(i) - 'a';
            int best = 0;
            
            for(int j = 0;j < 26;j++){
                if(Math.abs(j-c) <= k){
                    best = Math.max(best,dp[j]);
                }
            }
            
            dp[c] = Math.max(dp[c], best + 1);
            res = Math.max(res, dp[c]);
        }
        
        return res;
    }
}