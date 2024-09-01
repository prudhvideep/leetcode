class WordDictionary {
    public Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        Trie tempTrie = trie;

        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';

            if (tempTrie.elements[id] == null) {
                tempTrie.elements[id] = new Trie();
            }

            tempTrie = tempTrie.elements[id];
        }

        tempTrie.end = true;
    }

    public boolean search(String word) {

        Trie tempTrie = trie;
        if (dfs(0, word, tempTrie)) {
            return true;
        }

        return false;
    }

    public boolean dfs(int i, String word, Trie tempTrie) {
        if (i == word.length()) {
            return tempTrie.end;
        }

        if (word.charAt(i) != '.') {
            int id = word.charAt(i) - 'a';
            if (tempTrie.elements[id] == null) {
                return false;
            } else {
                if (dfs(i + 1, word, tempTrie.elements[id])) {
                    return true;
                }
            }
        } else {
            for (int j = 0; j < 26; j++) {
                if (tempTrie.elements[j] != null && dfs(i + 1, word, tempTrie.elements[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Trie {
    public boolean end;
    public Trie[] elements;

    Trie() {
        this.end = false;
        this.elements = new Trie[26];
    }

    Trie(int status) {
        this.end = true;
        this.elements = new Trie[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */