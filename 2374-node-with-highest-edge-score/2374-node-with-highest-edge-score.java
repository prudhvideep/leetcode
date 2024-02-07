class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        
        long score[] = new long[n];
        
        for(int i = 0;i < n;i++){
            int id = edges[i];
            score[id] += i;
        }
        
        long maxScore = Long.MIN_VALUE;
        int ele = -1;
        
        for(int i = 0;i < n;i++){
            if(maxScore < score[i]){
                maxScore = score[i];
                ele = i;
            }else if(maxScore == score[i]){
                if(i < ele){
                    ele = i;
                }
            }
        }
        
        return ele;
    }
}