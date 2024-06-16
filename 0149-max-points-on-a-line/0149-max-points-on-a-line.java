class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        
        int count = 0;
        double m;
        
        for(int i = 0;i < points.length;i++){
            HashMap<Double,Integer> hm = new HashMap<>();
            
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            for(int j = i+1;j < points.length;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if(x1 == x2){
                    m = Double.MAX_VALUE;
                }else if(y2 == y1){
                    m = 0.0;
                }else{
                    m = (double) ((y2-y1) * 1.0)/ (double) ((x2-x1)*1.0); 
                }
                
                
                hm.put(m,hm.getOrDefault(m,0)+1);
            }
            
            
            for(int val : hm.values()){
                count = Math.max(count,val+1);
            }
        }
        
        return count;
    }
}