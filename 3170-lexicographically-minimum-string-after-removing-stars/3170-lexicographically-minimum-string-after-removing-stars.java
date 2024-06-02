class Solution {
    public String clearStars(String s) {
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.c == b.c){
                return b.id-a.id;
            }
            
            return Character.compare(a.c,b.c);
        }); 
        
        Set <Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != '*'){
                pq.add(new Pair(s.charAt(i),i));
            }else{
                int id = pq.peek().id;
                pq.poll();
                
                set.add(id);
                set.add(i);
            }
        }
        
        for(int i = 0;i < s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }        
        
        return sb.toString();        
    }
    
    class Pair{
        public char c;
        public int id;
        
        Pair(char c, int id){
            this.c = c;
            this.id = id;
        }
    }
}