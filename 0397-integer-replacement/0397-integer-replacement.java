class Solution {
    HashMap <Integer,Integer> hm = new HashMap<>();
    
    public int integerReplacement(int n) {
        if(n >= Integer.MAX_VALUE) return 32;
        
        if(n == 1) return 0;
        if(n < 3) return 1;
        if(n < 5) return 2;
        
        if(n%2 == 0){
            if(!hm.containsKey(n/2)){
                hm.put(n/2,integerReplacement(n/2));
            }
            return 1+hm.get(n/2);
        }
        if(!hm.containsKey(n-1))
            hm.put(n-1,integerReplacement(n-1));
        
        if(!hm.containsKey(n+1))
            hm.put(n+1,integerReplacement(n+1));
        
        return 1+Math.min(hm.get(n-1),hm.get(n+1));
    }
}