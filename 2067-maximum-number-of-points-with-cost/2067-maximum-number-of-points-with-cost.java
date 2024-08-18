class Solution {
    public long maxPoints(int[][] points) {
        int r = points.length;
        int c = points[0].length;
        long dp [] = new long[c];
        long left[] = new long[c];
        long right[] = new long[c];

        for(int i = 0;i < c; i++){
            dp[i] = points[0][i];

        }
 
        long maxVal = 0;

        for(int i = 1; i < r;i++){
            for(int j = 0;j < c;j++){
                if(j == 0)
                {
                    left[j] = dp[j];
                    continue;
                }
                left[j] = Math.max(left[j-1]-1,dp[j]);
            }

            for(int j = c-1;j >= 0;j--){
                if(j == (c-1))
                {
                    right[j] = dp[j];
                    continue;
                }
                right[j] = Math.max(dp[j],right[j+1]-1);
            }


            for(int j = 0;j < c;j++){
                dp[j] = points[i][j] + Math.max(right[j],left[j]);
            }
        }

        for(int j = 0;j < c;j++){
            maxVal = Math.max(maxVal,dp[j]);
        }
        return maxVal;
    }
}