class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean [][] visited = new boolean[r][c];
        
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(findWord(i,j,0,board,word,visited))
                    return true;
            }
        }
        return false;
    }
    
    public boolean findWord(int i,int j,int id,char[][] board, String word, boolean[][] visited){
        int r = board.length, c = board[0].length;
        visited[i][j] = true;
        if(board[i][j] == word.charAt(id)){
            if(id == word.length()-1){
                return true;
            }
            if(i-1 >= 0 && !visited[i-1][j] && findWord(i-1,j,id+1,board,word,visited)){return true;}
            if(i+1 < r && !visited[i+1][j] && findWord(i+1,j,id+1,board,word,visited)){return true;}
            if(j-1 >= 0 && !visited[i][j-1] && findWord(i,j-1,id+1,board,word,visited)){return true;}
            if(j+1 < c && !visited[i][j+1] && findWord(i,j+1,id+1,board,word,visited)){return true;}
        }
        visited[i][j] = false;
        return false;
    }
}