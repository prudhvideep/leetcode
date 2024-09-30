class CustomStack {
    ArrayList <Integer> al = new ArrayList<>();
    int cap = 0;
    public CustomStack(int maxSize) {
        this.cap = maxSize;
    }
    
    public void push(int x) {
        if(al.size() < cap){
          al.add(x);
        }
    }
    
    public int pop() {
        if(al.size() == 0){
          return -1;
        }

        int top = al.get(al.size()-1);
        al.remove(al.size()-1);
        return top;
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i < Math.min(al.size(),k);i++){
          int c = al.get(i);
          al.set(i,c+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */