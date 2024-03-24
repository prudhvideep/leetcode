class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int [] a,int [] b) -> Integer.compare(a[0],b[0]));
        
        int ps = points[0][0];
        int pe = points[0][1];
        int arrows = 1;
        
        for(int i = 1; i < points.length;i++){
            int [] cur = points[i];
            //System.out.println(pe);
            //System.out.println(cur[0]);
            if(pe < cur[0]){
                arrows++;
                pe = cur[1];
                continue;
            }
            
            pe = Math.min(pe,cur[1]);
        }
        
        return arrows;
    }
}