class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap <Integer,Integer> hm = new HashMap<>();
        
        for(int i : arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue()-b.getValue()
        );

        pq.addAll(hm.entrySet());
        
        while(k > 0 && !pq.isEmpty()){
            Map.Entry <Integer,Integer> me = pq.peek();
            int v = me.getValue();
            if(v <= k){
                k -= v;
                pq.poll();
            }else{
                break;
            }
        }
        return pq.size();
    }
}