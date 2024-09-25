class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        HashMap <String,Integer> hm = new HashMap<>();
        int [] ret = new int[words.length];

        for(String word : words){
          insert(trie,word);
        }

        for(int i = 0;i < words.length;i++){
          ret[i] = search(trie,words[i]);
        }

        return ret;
    }

    public int search(Trie trie, String str){
      Trie temp = trie;
      int count = 0;
      for(int i = 0;i < str.length();i++){
        int id = str.charAt(i) - 'a';
        temp = temp.ele[id];
        count += temp.count;
      }
      return count;
    }

    public void insert(Trie trie, String str){
      Trie temp = trie;
      for(int i = 0;i < str.length();i++){
        int id = str.charAt(i) - 'a';
        
        if(temp.ele[id] == null){
          temp.ele[id] = new Trie();
        }
        
        temp = temp.ele[id];
        temp.count++;
      }
    }

    class Trie {
      public int count;
      public Trie [] ele;

      Trie(){
        count = 0;
        ele = new Trie[26];

        for(int i = 0;i < 26;i++){
          ele[i] = null;
        }
      }
    }
}