class Solution {
  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
      return p2.ct - p1.ct;
    });
    
    if(a != 0)
      pq.add(new Pair('a', a));
    
    if(b != 0)
      pq.add(new Pair('b', b));

    if(c != 0)
      pq.add(new Pair('c', c));

    StringBuilder sb = new StringBuilder();

    while (pq.size() > 1) {
      Pair f = pq.poll();
      Pair s = pq.poll();

      if (f.ct == s.ct && (f.ct != 0)) {
        if (f.ct >= 2) {
          sb.append(f.ch);
          sb.append(f.ch);
          sb.append(s.ch);
          sb.append(s.ch);

          f.ct -= 2;
          s.ct -= 2;
        } else if (f.ct == 1) {
          sb.append(f.ch);
          sb.append(s.ch);
          f.ct -= 1;
          s.ct -= 1;
        }
      } else {
        if (f.ct >= 2) {
          sb.append(f.ch);
          sb.append(f.ch);

          f.ct -= 2;
        } else {
          while (f.ct-- > 0) {
            sb.append(f.ch);
          }
        }

        if (s.ct >= 1) {
          sb.append(s.ch);
          s.ct -= 1;
        }
      }

      if (f.ct > 0) {
        pq.add(f);
      }

      if (s.ct > 0) {
        pq.add(s);
      }
    }

    if (pq.size() == 1) {
      Pair p = pq.poll();
      int ct = Math.min(2, p.ct);
      if (sb.length() > 0 && (p.ch != sb.charAt(sb.length() - 1))) {
        while (ct-- > 0) {
          sb.append(p.ch);
        }
      }else if(sb.length() == 0){
        if(ct >= 2){
           sb.append(p.ch);
            sb.append(p.ch);
        }else{
           sb.append(p.ch);
        }
      }
    }

    return sb.toString();
  }

  class Pair {
    char ch;
    int ct;

    Pair(char ch, int ct) {
      this.ch = ch;
      this.ct = ct;
    }
  }
}