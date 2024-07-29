class LRUCache {
    public int capacity;
    HashMap <Integer,Integer> hm = new HashMap <> ();
    Set <Integer> set = new LinkedHashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            set.remove(key);
            set.add(key);
            return hm.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(hm.size() < capacity){
            if(hm.containsKey(key)){
                set.remove(key);
            }else{
                hm.put(key,value);
            }
        }else if(hm.size() >= capacity){
            if(hm.containsKey(key)){    
                set.remove(key);     
            }else{
                int keyToRemove = set.iterator().next();
                hm.remove(keyToRemove);
                set.remove(keyToRemove);
            }
        }
        
        hm.put(key,value);
        set.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */