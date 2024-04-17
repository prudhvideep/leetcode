class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                char c = board[i][j];
                
                if(board[i][j] != '.'){
                    if(!seen.add(c + " seen in row " + i) || 
                       !seen.add(c + " seen in col " + j) || 
                      !seen.add(c + " seen in box" + i/3+"-"+j/3))
                        return false;
                }
            }
        }
        
        return true;
    }
}