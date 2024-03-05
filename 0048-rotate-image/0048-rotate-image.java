class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        
        for(int i = 0;i < r;i++){
            for(int j = i; j < c;j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
        for(int i = 0;i < r;i++){
            reverseArray(matrix[i],c);
        }
    }
    
    public void reverseArray(int [] a,int n){
        int l = 0, h = n-1;
        
        while(l <= h){
            int temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            
            l++;h--;
        }
    }
}