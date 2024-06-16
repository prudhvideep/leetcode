class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b)-> b.n - a.n);
        int n = nums.length, id = 0;
        
        int max [] = new int[n-k+1];
        
        for(int i = 0; i < k;i++){
            pq.add(new Pair(nums[i],i));
        }
        
        max[id++] = pq.peek().n;
        
        for(int i = k; i < n;i++){
            pq.add(new Pair(nums[i],i));
            
            while(pq.peek().i <= i-k){
                pq.poll();
            }
            
            max[id++] = pq.peek().n;
        }
        
        return max;
    }
    
    class Pair{
        public int n;
        public int i;
        
        Pair(int n, int i){
            this.n = n;
            this.i = i;
        }
    }
}