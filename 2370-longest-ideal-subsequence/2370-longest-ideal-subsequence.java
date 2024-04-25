class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        if(n == 1)
            return 1;
        
        int [] dp = new int[26];
        int maxLen = 0,best,c;
        
        for(int i = 0;i < n;i++){
            c = s.charAt(i) - 'a';
            best = 0;
            for(int j = 0;j < 26;j++){
                if(Math.abs(c-j) <= k){
                    best = Math.max(dp[j],best);
                }
            }
            dp[c] = Math.max(dp[c],1+best);
            maxLen = Math.max(maxLen,dp[c]);
        }
        
        return maxLen;
    }
}