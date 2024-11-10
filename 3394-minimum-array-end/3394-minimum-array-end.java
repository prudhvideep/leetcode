class Solution {
  public long bin2long(int[] bX) {
    long ret = 0;

    for (int i = 0; i < 32; i++) {
      int mask = (1 << i);
      if (bX[i] == 1) {
        ret += (mask);
      }
    }

    return ret;
  }

  public long minEnd(int n, int x) {
    long result = x;

    while (--n > 0) {
      result = (result + 1) | x;
    }

    return result;
  }
}