class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
        List<int []> list = new ArrayList<>();
        
        int i = 0, n = interval.length;
        
        while(i < n && newInterval[0] > interval[i][1]){
            list.add(interval[i]);
            i++;
        }
        
        while(i < n && newInterval[1] >= interval[i][0]){
            newInterval[0] = Math.min(interval[i][0],newInterval[0]);
            newInterval[1] = Math.max(interval[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        
        while(i < n){
            list.add(interval[i]);
            i++;
        }
        
        int [][] ret = new int[list.size()][];
        
        for(int j = 0;j < list.size();j++){
            ret[j] = list.get(j);
        }
        
        return ret;
    }
}