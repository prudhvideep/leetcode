class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
      int [] ti = times[targetFriend];
      int sch = 0;

      PriorityQueue <Integer> chPq = new PriorityQueue<>();
      PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> {
        return a.dp - b.dp;
      });

      Arrays.sort(times, (a,b) -> {
        return a[0] - b[0];
      });

      for(int i = 0;i <= times.length;i++){
        chPq.add(i);
      }

      for(int i = 0; i < times.length;i++){
         int [] ci = times[i];


         while(!pq.isEmpty() && pq.peek().dp <= ci[0]){
          int ch = pq.peek().ch;
          chPq.add(ch);
          pq.poll();
         }
        
         if(ci[0] == ti[0] && ci[1] == ti[1]){
          System.out.println(chPq.peek());
          sch = chPq.peek();
          break;
         }

         pq.add(new Pair(ci[1],chPq.poll()));
         
      }

      return sch;
              
    }

    class Pair{
      int dp;
      int ch;

      Pair(int dp,int ch){
        this.dp = dp;
        this.ch = ch;
      }
    }
}