class Solution {
    public int[][] findFarmland(int[][] land) {
        List <int []> list = new ArrayList<>();
        
        for(int i = 0;i < land.length;i++){
            for(int j = 0;j < land[0].length;j++){
                if(land[i][j] == 1){
                    int [] arr = new int[4];
                    arr[0] = i;
                    arr[1] = j;
                    dfs(i,j,land,arr);
                    list.add(arr);
                }
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
    
    public void dfs(int row,int col, int [][] land, int [] arr){
        land[row][col] = 2;
        
        arr[2] = Math.max(arr[2],row);
        arr[3] = Math.max(arr[3],col);
        
        if(row-1 >= 0 && land[row-1][col] == 1)
            dfs(row-1,col,land,arr);
        
        if(row+1 < land.length && land[row+1][col] == 1)
            dfs(row+1,col,land,arr);
        
        if(col-1 >= 0 && land[row][col-1] == 1)
            dfs(row,col-1,land,arr);
        
        if(col+1 < land[0].length && land[row][col+1] == 1)
            dfs(row,col+1,land,arr);
    }
}