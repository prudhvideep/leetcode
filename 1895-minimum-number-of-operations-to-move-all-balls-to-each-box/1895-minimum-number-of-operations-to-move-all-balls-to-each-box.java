class Solution {
  public int[] minOperations(String boxes) {
    int n = boxes.length();
    int[] ret = new int[n];

    cost[] lCost = new cost[n];

    cost[] rCost = new cost[n];
    for (int i = 0; i < n; i++) {
      lCost[i] = new cost(0, 0);
      rCost[i] = new cost(0, 0);
    }

    lCost[0].b = boxes.charAt(0) - '0';
    for (int i = 1; i < boxes.length(); i++) {
      lCost[i].b = (boxes.charAt(i) == '1' ? 1 : 0) + lCost[i - 1].b;
      lCost[i].c = lCost[i - 1].c + lCost[i - 1].b;
    }

    rCost[n - 1].b = boxes.charAt(n - 1) - '0';

    for (int i = n - 2; i >= 0; i--) {
      rCost[i].b = (boxes.charAt(i) == '1' ? 1 : 0) + rCost[i + 1].b;
      rCost[i].c = rCost[i + 1].c + rCost[i + 1].b;
    }

    for (int i = 0; i < n; i++) {
      ret[i] = lCost[i].c + rCost[i].c;
    }

    return ret;
  }

  public class cost {
    int b;
    int c;

    cost(int b, int c) {
      this.b = b;
      this.c = c;
    }

    public String toString() {
      return "b -> " + this.b + " " + "c -> " + this.c;
    }
  }
}