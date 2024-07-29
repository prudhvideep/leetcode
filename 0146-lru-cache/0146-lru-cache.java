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
            // System.out.println("get " + key + "     " + set);
            return hm.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(hm.size() < capacity){
            if(hm.containsKey(key)){
                hm.put(key,value);
                set.remove(key);
                set.add(key);
            }else{
                hm.put(key,value);
                set.add(key);
            }
        }else if(hm.size() == capacity){
            if(hm.containsKey(key)){
                hm.put(key,value);
                set.remove(key);
                set.add(key);
            }else{
                Iterator <Integer> it = set.iterator();
                int keyToRemove = -1;
                if(it.hasNext()){
                    keyToRemove = it.next();
                }

                hm.remove(keyToRemove);
                set.remove(keyToRemove);

                hm.put(key,value);
                set.add(key);
            }
        }
        // System.out.println("put " + key + " " + value + "   " + set);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */