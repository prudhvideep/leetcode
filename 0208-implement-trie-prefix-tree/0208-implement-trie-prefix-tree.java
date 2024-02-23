class Trie {
    public boolean isPresent;
    public Trie [] arr; 
    
    public Trie() {
        this.isPresent = false;
        this.arr = new Trie[26];
        
        for(int i = 0;i < 26;i++){
            arr[i] = null;            
        }
    }
    
    public void insert(String word) {
        insertUtil(0,word,this);
    }
    
    public void insertUtil(int id,String word, Trie trie){
        if(id == word.length()){
            trie.isPresent = true;
            return;   
        }
        
        char c = word.charAt(id);
        
        if(trie.arr[c-'a'] == null){
            trie.arr[c-'a'] = new Trie();
        }
        
        insertUtil(id+1,word,trie.arr[c-'a']);
    }
    
    public boolean search(String word) {
        return searchUtil(0,word,this);
    }
    
    public boolean searchUtil(int id, String word, Trie trie){
        if(id == word.length()){
            return trie.isPresent;
        }
        
        char c = word.charAt(id);
        
        if(trie.arr[c-'a'] == null){
            return false;
        }
        return searchUtil(id+1,word,trie.arr[c-'a']);
    }
    
    public boolean startsWith(String prefix) {
        return prefixUtil(0,prefix,this);
    }
    
    public boolean prefixUtil(int id, String prefix, Trie trie){
        if(id == prefix.length()){
          return true;  
        }
        
        char c = prefix.charAt(id);
        
        if(trie.arr[c-'a'] == null){
          return false;   
        }
        
        return prefixUtil(id+1,prefix,trie.arr[c-'a']);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */