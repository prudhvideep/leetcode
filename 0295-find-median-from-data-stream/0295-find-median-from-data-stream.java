class MedianFinder {
    PriorityQueue <Integer> minHeap;
    PriorityQueue <Integer> maxHeap;

    public MedianFinder() {
      this.minHeap = new PriorityQueue<>();
      this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
      if(minHeap.size() == 0 && maxHeap.size() == 0) {
          maxHeap.add(num);
          return;
      }

      if(maxHeap.peek() > num){
        maxHeap.add(num);
      }else{
        minHeap.add(num);
      }

      rebalance();
    }

    private void rebalance() {
      if(maxHeap.size() > (minHeap.size() + 1)){
        int head = maxHeap.poll();
        minHeap.add(head);
      }else if(minHeap.size() > (maxHeap.size() + 1)){
        int head = minHeap.poll();
        maxHeap.add(head);
      }
    }
    
    public double findMedian() {
      if(minHeap.size() == maxHeap.size()) {
        double a = (double) maxHeap.peek();
        double b = (double) minHeap.peek();
        
        return (a+b)/2;
        
      }else if(minHeap.size() > maxHeap.size()) {
        return (double) minHeap.peek();
      }else {
        return (double) maxHeap.peek();
      }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */