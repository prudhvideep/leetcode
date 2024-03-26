class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(int [] a,int [] b)-> Integer.compare(a[0],b[0]));
                
        int count = 0;
        
        int [] pre = intervals[0];
        int ps = pre[0];
        int pe = pre[1];
        
        for(int i = 1;i < intervals.length;i++){
            
            int [] cur = intervals[i];
            if(pe > cur[0]){
                count++;
                pe = Math.min(pe,cur[1]);
                continue;
            }
            
            pe = cur[1];
        
        }
        
        return count;
    }
}