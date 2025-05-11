class Solution {
  public int minSwaps(String s) {
    int n = s.length();
    int ones = 0, zero = 0;
    for (char c : s.toCharArray()) {
      if (c == '1')
        ++ones;
      else
        ++zero;
    }

    if (Math.abs(ones - zero) > 1)
      return -1;

    int diff1 = getDiff(s, '0');
    int diff2 = getDiff(s, '1');

    if (diff1 == -1 && diff2 == -1) {
      return -1;
    } else if (diff1 == -1) {
      return diff2;
    } else if (diff2 == -1) {
      return diff1;
    } else {
      return Math.min(diff1, diff2);
    }
  }

  public int getDiff(String s, char start) {
    int diff = 0;

    for (int i = 0; i < s.length(); i++) {
      char expected = (i % 2 == 0) ? start : ((start == '0') ? '1' : '0');
      if (expected != s.charAt(i)) {
        diff++;
      }
    }

    return (diff % 2 == 0) ? diff / 2 : -1;

  }
}