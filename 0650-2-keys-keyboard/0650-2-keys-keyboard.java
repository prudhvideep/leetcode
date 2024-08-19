class Solution {
    public int minSteps(int n) {

        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2;i <= n;i++){
            if(i%2 == 0){
                dp[i] = 2 + dp[i/2];
            }else{
                int minVal = Integer.MAX_VALUE;
                boolean isPrime = true;
                for(int k = 3; k <= (i/2);k+=2){
                    if(i%k == 0){
                        isPrime = false;
                        minVal = Math.min(minVal,dp[k] + (i/k));
                    }
                }
                if(isPrime){
                    dp[i] = i;
                }else{
                    dp[i] = minVal;
                }
            }

            
        }
        return dp[n];
    }
}