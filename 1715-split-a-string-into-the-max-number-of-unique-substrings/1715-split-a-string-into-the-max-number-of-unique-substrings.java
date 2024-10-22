class Solution {
  int len = 1;

  public int maxUniqueSplit(String s) {
    Set<String> set = new HashSet<>();
    int n = s.length();
    generateStrings(0,s, set, n);

    return len;
  }

  void generateStrings(int id, String s, Set<String> set, int n) {
    if (id >= n) {
      len = Math.max(len,set.size());
      return;
    }

    for (int i = id; i < s.length(); i++) {
      String s1 = s.substring(id, i + 1);
      String s2 = s.substring(i + 1, s.length());
      if (set.contains(s1)) {
        continue;
      } else {
        set.add(s1);
        generateStrings(i+1,s, set,n);
        set.remove(s1);
      }
    }

  }
}