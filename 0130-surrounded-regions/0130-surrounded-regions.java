class Solution {
    public int r = 0, c = 0;
    public void solve(char[][] board) {
        r = board.length; c = board[0].length;
        boolean [][] visited = new boolean[r][c];
        
        for(int i = 0;i < r;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,visited);
            }
            
            if(board[i][c-1] == 'O'){
                dfs(i,c-1,board,visited);
            }
        }
        
        for(int i = 0;i < c;i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board,visited);
            }
            
            if(board[r-1][i] == 'O'){
                dfs(r-1,i,board,visited);
            }
        }
        
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void dfs(int i,int j, char [][] board, boolean [][] visited){
        if(visited[i][j])
            return;
        
        visited[i][j] = true;
        
        if(i-1 >= 0 && !visited[i-1][j] && board[i-1][j] == 'O')dfs(i-1,j,board,visited);
        if(i+1 < r && !visited[i+1][j] && board[i+1][j] == 'O')dfs(i+1,j,board,visited);
        if(j-1 >= 0 && !visited[i][j-1] && board[i][j-1] == 'O')dfs(i,j-1,board,visited);
        if(j+1 < c && !visited[i][j+1] && board[i][j+1] == 'O')dfs(i,j+1,board,visited);
    }
}