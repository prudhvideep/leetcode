class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue <int []> q = new ArrayDeque<>();
        
        int r = mat.length;
        int c = mat[0].length;
        
        int [][] ra = new int [r][c];
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                    ra[i][j] = 0;
                }                        
                else
                    ra[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            int [] ia = q.poll();
            int i = ia[0];
            int j = ia[1];
            
            if(i-1 >= 0 && ra[i-1][j] == -1){
                ra[i-1][j] = 1+ra[i][j];
                q.add(new int[] {i-1,j});
            }
            
            if(i+1 < r && ra[i+1][j] == -1){
                ra[i+1][j] = 1+ra[i][j];
                q.add(new int[] {i+1,j});
            }
                
            if(j-1 >= 0 && ra[i][j-1] == -1){
                ra[i][j-1] = 1+ra[i][j];
                q.add(new int[] {i,j-1});
            }
            
            if(j+1 < c && ra[i][j+1] == -1){
                ra[i][j+1] = 1+ra[i][j];
                q.add(new int[] {i,j+1});
            }
        }
        
        return ra;
    }
}