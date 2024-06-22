class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;
        
        int l = 0;
        int h = (int) Math.sqrt(c);
        
        while(l <= h){
          long sum = (long)(l*l) + (long)(h*h);
            
          if(sum == c){
              return true;
          }else if(sum < c){
              l++;
          }else{
              h--;
          }
        }
            
        return false;
    }
}