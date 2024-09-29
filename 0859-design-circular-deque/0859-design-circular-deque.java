class MyCircularDeque {
    public int c = 0;
    public ArrayDeque <Integer> dq;
    public MyCircularDeque(int k) {
        this.c = k;
        this.dq = new ArrayDeque<>();
    }
    
    public boolean insertFront(int value) {
        if(dq.size() < c){
          dq.addFirst(value);
          return true;
        }

        return false;
    }
    
    public boolean insertLast(int value) {
        if(dq.size() < c){
          dq.addLast(value);
          return true;
        }

        return false;
    }
    
    public boolean deleteFront() {
       if(dq.size() > 0){
        dq.removeFirst();
        return true;
       }

       return false;
    }
    
    public boolean deleteLast() {
        if(dq.size() > 0){
          dq.removeLast();
          return true;
        }
        return false;
    }
    
    public int getFront() {
        if(dq.size() > 0)
          return dq.getFirst();
        
        return -1;
    }
    
    public int getRear() {
       if(dq.size() > 0)
        return dq.getLast();

        return -1;
    }
    
    public boolean isEmpty() {
        if(dq.size() == 0)
          return true;

        return false;
    }
    
    public boolean isFull() {
        if(dq.size() == c){
          return true;
        }

        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */