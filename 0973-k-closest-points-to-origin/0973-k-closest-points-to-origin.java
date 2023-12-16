class Solution {
    
    public double dist(int [] point){
        int x1 = point[0], y1 = point[1];
        return Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));            
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int [][] r  = new int[k][];
        
        Arrays.sort(points, (a,b) -> Double.compare(dist(a),dist(b)));
        
        for(int i = 0;i < k ;i++){
            r[i] = points[i];
        }
        return r;
    }
}