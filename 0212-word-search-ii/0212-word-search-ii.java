class Solution {
  public int r = 0, c = 0;
  public Set<String> set = new HashSet<>();

  class Trie {
    boolean [] isWord;
    Trie[] ele;

    Trie() {
      this.isWord = new boolean[26];
      this.ele = new Trie[26];
      for (int i = 0; i < 26; i++) {
        this.ele[i] = null;
      }
    }
  }

  public void insert(Trie root, String word) {
    Trie temp = root;

    for (int i = 0; i < word.length(); i++) {
      int id = word.charAt(i) - 'a';

      if (temp.ele[id] == null) {
        temp.ele[id] = new Trie();
      }

      if (i == (word.length() - 1)) {
        temp.isWord[id] = true;
      }

      temp = temp.ele[id];
    }

  }

  public void dfs(int i, int j, Trie root, char[][] board, boolean[][] visited, StringBuilder curStr) {

    if (visited[i][j])
      return;

    char ch = board[i][j];
    int id = ch - 'a';

    if (root.ele[id] == null) {
      return;
    }

    visited[i][j] = true;

    curStr.append(ch);
    if (root.isWord[id]) {
      set.add(curStr.toString());
    }

    if ((i - 1) >= 0) {
      dfs(i - 1, j, root.ele[id], board, visited, curStr);
    }

    if ((i + 1) < r) {
      dfs(i + 1, j, root.ele[id], board, visited, curStr);
    }

    if ((j - 1) >= 0) {
      dfs(i, j - 1, root.ele[id], board, visited, curStr);
    }

    if ((j + 1) < c) {
      dfs(i, j + 1, root.ele[id], board, visited, curStr);
    }

    visited[i][j] = false;
    curStr.deleteCharAt(curStr.length() - 1);
  }

  public List<String> findWords(char[][] board, String[] words) {
    Trie root = new Trie();
    r = board.length;
    c = board[0].length;
    List <String> ret = new ArrayList<>();

    StringBuilder curStr = new StringBuilder();
    boolean[][] visited = new boolean[r][c];

    for (String word : words) {
      insert(root, word);
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        dfs(i, j, root, board, visited, curStr);
      }
    }

    for(String s : set){
      ret.add(s);
    }

    return ret;
  }
}