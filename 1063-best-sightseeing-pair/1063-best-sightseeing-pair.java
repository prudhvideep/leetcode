class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        
        if(n == 2){
          return values[0] + values[1] - 1; 
        }


        int [] suf = new int[n];
        
        suf[n-1] = values[n-1] - (n-1);

        for(int i = n-2;i >= 0;i--){
          suf[i] = Math.max((values[i] - i),suf[i+1]);
        }

        int maxS = Integer.MIN_VALUE;

        for(int i = 0;i < values.length - 1;i++){
          maxS = Math.max(maxS,(values[i] + i + suf[i+1]));
        }

        return maxS;
    }
}