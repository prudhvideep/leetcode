class Solution {
  public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for(int i = 0; i < m;i++){
          int l = n-2, r = n-1;

          while(l >= 0 && r >= 0){
            if(box[i][l] == '#' && box[i][r] == '.'){
              box[i][l] = '.';
              box[i][r] = '#';

              l--;
              r--;
            }else if(box[i][l] == '.' && box[i][r] == '.'){
              l--;
            }else if(box[i][l] == '*'){
              r = l-1;
              l = l-2;
            }else if(box[i][l] == '#' && box[i][r] == '#'){
              l--;r--;
            }else if(box[i][r] == '#' || box[i][r] == '*'){
              l--;r--;
            }
          }
        }

        // for(int i = 0;i < m; i++){
        //   for(int j =0 ;j < n;j++){
        //     System.out.print(box[i][j] + " ");
        //   }
        //   System.out.println();
        // }

        char [][] newBox = new char[n][m];

        for(int i = 0;i < n;i++){
          for(int j = 0;j < m;j++){
            newBox[i][j] = box[m-j-1][i];
          }
        }
       
       return newBox;
    }
}