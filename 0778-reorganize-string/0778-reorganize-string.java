class Solution {
  public String reorganizeString(String s) {
    if(s.length() == 1) return s;

    StringBuilder sb = new StringBuilder();
    int[] count = new int[26];

    for (var c : s.toCharArray()) {
      count[c - 'a']++;
    }

    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
    for(int i = 0; i < 26;i++){
      if(count[i] > 0){
        pq.add((char) (i + 'a'));
      }
    }

    if (pq.size() == 1) {
      return "";
    }

    System.out.println(pq);

    while (!pq.isEmpty()) {
      char a, b;
      if (pq.size() > 1) {
        a = pq.poll();
        b = pq.poll();

        count[a - 'a']--;
        count[b - 'a']--;

        if (count[a - 'a'] > 0) {
          pq.add(a);
        }

        if (count[b - 'a'] > 0) {
          pq.add(b);
        }

        sb.append(a);
        sb.append(b);
      }else if(pq.size() == 1){
        a = pq.poll();

        if(count[a-'a'] == 1){
          sb.append(a);
        }else{
          return "";
        }
      }

    }

    return sb.toString();
  }
}