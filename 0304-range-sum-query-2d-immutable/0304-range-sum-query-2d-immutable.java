class NumMatrix {
    public int [][] matrix;
    public int [][] prefix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prefix = new int[matrix.length][matrix[0].length];
        
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                prefix[i][j] = (j == 0)? matrix[i][0]: (prefix[i][j-1] + matrix[i][j]);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        for(int i = row1; i <= row2; i++){
           sum += (prefix[i][col2] - prefix[i][col1]) + matrix[i][col1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */