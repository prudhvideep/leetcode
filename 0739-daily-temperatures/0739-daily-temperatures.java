class Solution {
    class pair{
        public int temp;
        public int id;
        pair(int temp,int id){
            this.temp = temp;
            this.id = id;
        }
    }
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ret = new int[n];
        
        Stack <pair> s = new Stack<>();
        s.add(new pair(temperatures[0],0));
        
        for(int i = 1;i < n;i++){
           while(!s.isEmpty() && s.peek().temp < temperatures[i]){
               int id = s.peek().id;
               ret[id] = i - id;
               s.pop();
           }
           s.add(new pair(temperatures[i],i));
        }
        
        return ret;
    }
}