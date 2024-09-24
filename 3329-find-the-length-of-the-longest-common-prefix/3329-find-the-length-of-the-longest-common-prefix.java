class Solution {
  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    int maxLen = 0;
    Trie trie = new Trie();
    for (int i : arr1) {
      insert(trie, i);
    }

    for (int i : arr2) {
      maxLen = Math.max(maxLen, search(trie, i));
    }

    return maxLen;
  }

  public List<Integer> getPrefix(int a) {
    List<Integer> list = new ArrayList<>();

    while (a != 0) {
      list.add(a % 10);
      a = a / 10;
    }

    Collections.reverse(list);

    return list;
  }

  public int search(Trie trie, int e) {
    Trie temp = trie;
    List<Integer> list = getPrefix(e);
    int len = 0;
    for (int i = 0; i < list.size(); i++) {
      int id = list.get(i);
      if (temp.ele[id] == null) {
        break;
      }

      len = Math.max(len, i + 1);

      temp = temp.ele[id];
    }

    return len;
  }

  public void insert(Trie trie, int e) {
    Trie temp = trie;

    List<Integer> list = getPrefix(e);

    for (int i = 0; i < list.size(); i++) {
      int id = list.get(i);
      if (temp.ele[id] == null) {
        temp.ele[id] = new Trie();
      }

      if (i == list.size() - 1) {
        temp.isEnd[id] = true;
      }

      temp = temp.ele[id];
    }
  }

  class Trie {
    public boolean[] isEnd;
    public Trie[] ele;

    Trie() {
      this.isEnd = new boolean[10];
      this.ele = new Trie[10];

      Arrays.fill(isEnd, false);
      for (int i = 0; i < 10; i++) {
        ele[i] = null;
      }
    }
  }
}