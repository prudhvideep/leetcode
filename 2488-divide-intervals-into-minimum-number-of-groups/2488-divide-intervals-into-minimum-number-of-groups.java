class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
          return a[0]-b[0];
        });
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < intervals.length;i++){
          int [] ci = intervals[i];
          if(pq.size() == 0){
            pq.add(ci[1]);
            continue;
          }

          if(ci[0] > pq.peek()){
            pq.poll();
          }
          
          pq.add(ci[1]);
        }

        return pq.size();
    }
}