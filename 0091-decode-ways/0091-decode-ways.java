class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int [n+1];
        
                
        dp[n] = 1;
        
        for(int i = n-1;i >=0 ;i--){
            char c = s.charAt(i);
            if(c == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i+1];
                if(i < n-1 && (c == '1' || (c == '2' && s.charAt(i + 1) <= '6'))){
                    dp[i] += dp[i+2]; 
                }
            }
        }
        return dp[0];
    }
}