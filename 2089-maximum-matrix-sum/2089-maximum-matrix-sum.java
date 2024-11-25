class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totSum = 0;
        int nCount = 0, le = Integer.MAX_VALUE;

        for (int [] row : matrix){
          for(int ele : row){
            le = Math.min(le,Math.abs(ele));

            if(ele < 0){
              nCount++;
            }

            totSum += Math.abs(ele);
          }
        }

        if(nCount%2 != 0){
          totSum -= (2*le);
        }

        return totSum;
    }
}