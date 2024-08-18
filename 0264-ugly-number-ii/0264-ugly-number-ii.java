class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 1, i3 = 1, i5 = 1;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n;i++){
            int nm2 = dp[i2] * 2;
            int nm3 = dp[i3] * 3;
            int nm5 = dp[i5] * 5;

            dp[i] = Math.min(nm2,Math.min(nm3,nm5));

            if(dp[i] == nm2){
                i2++;
            }

            if(dp[i] == nm3){
                i3++;
            }

            if(dp[i] == nm5){
                i5++;
            }
        }

        return dp[n];
    }
}