class Solution {
    public String frequencySort(String s) {
        Map <Character,Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(mp.entrySet());
        
        StringBuffer sb = new StringBuffer();
        
        while(!pq.isEmpty()){
            
            Map.Entry<Character,Integer> me = pq.peek();
            pq.poll();
            
            int n = me.getValue();
            char c = me.getKey();
            
            while(n-- > 0){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}