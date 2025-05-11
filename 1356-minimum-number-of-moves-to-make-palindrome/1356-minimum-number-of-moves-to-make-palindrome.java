class Solution {
    public int minMovesToMakePalindrome(String s) {
        int moves = 0,n = s.length()-1;

        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > 0) {
          char lCh = sb.charAt(sb.length()-1);
          int i = sb.indexOf(String.valueOf(lCh));
          if(i == (sb.length()-1)){
            moves += (i/2);
          }else{
            moves += i;
            sb.deleteCharAt(i);
          }
          
          sb.deleteCharAt(sb.length()-1);
        }
        
        return moves;
    }
}