class Solution {
  public char findKthBit(int n, int k) {
    StringBuilder sb = new StringBuilder();
    StringBuilder rb = new StringBuilder();

    sb.append('0');

    for (int i = 1; i < n; i++) {
      rb.setLength(0);
      rb.append(sb);
      rb.reverse();

      sb.append("1");

      for (int j = 0; j < rb.length(); j++) {
        if (rb.charAt(j) == '1') {
          sb.append('0');
          continue;
        }
        sb.append('1');
      }

    }

    return sb.charAt(k-1);
  }
}