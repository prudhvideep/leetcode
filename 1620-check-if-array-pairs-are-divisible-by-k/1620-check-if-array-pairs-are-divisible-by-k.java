class Solution {
  public boolean canArrange(int[] arr, int k) {
    int fre[] = new int[k];

    for(int i : arr){
      int r = i % k;
      if(r < 0) {
        r+= k;
      }

      fre[r]++;
    }

    if(fre[0] % 2 != 0)
      return false;

    for(int i = 1;i <= k/2;i++){
      if(fre[i] != fre[k-i]){
        return false;
      }
    }

    return true;
  }
}