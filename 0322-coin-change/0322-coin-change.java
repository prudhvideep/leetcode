class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        
        dp[0][0] = 0;
        for(int j = 1;j <= amount;j++){
            if(coins[0] > j){
                dp[0][j] = -1;
            }else{
                if(dp[0][j-coins[0]] != -1)
                    dp[0][j] = 1 + dp[0][j-coins[0]];
                else
                    dp[0][j] = -1;
            }
        }
        
        for(int i = 1; i < n;i++){
            for(int j = 0;j <= amount;j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(dp[i][j-coins[i]] != -1){
                        if(dp[i-1][j] != -1)
                         dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
                        else
                         dp[i][j] = 1+dp[i][j-coins[i]];
                    }
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n-1][amount];
    }
}