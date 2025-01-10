class Solution {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int[] ret = new int[code.length];

    if (k == 0) {
      return ret;
    } else if (k < 0) {
      int sum = 0;
      for (int i = 0; i < Math.abs(k); i++) {
        sum += code[n - i - 1];
      }

      for(int i = 0;i < code.length;i++){
        ret[i] = sum;
        sum += code[i];
        sum -= code[(n + i - Math.abs(k))%n];
      }
    } else if(k > 0){
      int sum = 0;
      for (int i = 0; i < k; i++) {
        sum += code[i+1];
      }

      for(int i = 0;i < code.length;i++){
        ret[i] = sum;

        sum += code[(i+k+1)%n];
        sum -= code[(i+1)%n]; 
      }
    }
    return ret;
  }
}