class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] ret = new int[0][0];

        if((original.length/m) != n)
            return ret;

        ret = new int[m][n];

        int count = 0,r = 0,c = 0;
        
        for(int i = 0;i < original.length;i++){
            if(count < n){
                count+=1;
                ret[r][c] = original[i]; 
            }else{
                count = 1;
                r = r+1;c = 0;
                ret[r][c] = original[i]; 
            }
            c++;
        }

        return ret;
    }
}