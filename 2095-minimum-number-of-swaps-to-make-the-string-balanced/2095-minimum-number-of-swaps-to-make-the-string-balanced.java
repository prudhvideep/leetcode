class Solution {
    public int minSwaps(String s) {
        int openb = 0;
        int unbalanced = 0;

        for(int i = 0;i < s.length();i++){
          char c = s.charAt(i);
          if(c == '['){
            openb++;
          }else{
            if(openb > 0){
              openb--;
            }else{
              unbalanced++;
            }
          }
        }

        return (unbalanced+1)/2;
    }
}