class Solution {
  class Pair {
    int first;
    int second;

    Pair(int a, int b) {
      this.first = a;
      this.second = b;
    }

  }

  public long numberOfWays(String s) {
    int n = s.length();
    Pair[] pf = new Pair[n];
    for (int i = 0; i < n; i++)
      pf[i] = new Pair(0, 0);

    Pair[] sf = new Pair[n];
    for (int i = 0; i < n; i++)
      sf[i] = new Pair(0, 0);

    for (int i = 0; i < n; i++) {
      int num = s.charAt(i) - '0';

      if (i == 0) {
        if (num == 0) {
          pf[i].first = 1;
        } else {
          pf[i].second = 1;
        }
        continue;
      }

      if (num == 0) {
        pf[i].first = (pf[i - 1].first + 1);
        pf[i].second = (pf[i - 1].second);
      } else {
        pf[i].second = (pf[i - 1].second + 1);
        pf[i].first = (pf[i - 1].first);
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      int num = s.charAt(i) - '0';

      if (i == (n - 1)) {
        if (num == 0) {
          sf[i].first = 1;
        } else {
          sf[i].second = 1;
        }
        continue;
      }

      if (num == 0) {
        sf[i].first = (sf[i + 1].first + 1);
        sf[i].second = (sf[i + 1].second);
      } else {
        sf[i].first = (sf[i + 1].first);
        sf[i].second = (sf[i + 1].second + 1);
      }
    }

    long count = 0;

    for (int i = 1; i < n - 1; i++) {
      int num = s.charAt(i) - '0';

      if (num == 0) {
        count += (1L * pf[i - 1].second * sf[i + 1].second);
      } else {
        count += (1L * pf[i - 1].first * sf[i + 1].first);
      }
    }

    return count;

  }
}