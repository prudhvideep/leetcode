class Solution {
    class Pair{
        int [] point;
        double d;
        
        Pair(int [] a,double b){
            this.point = a;
            this.d = b;
        }
    }
    
    public double dist(int [] point){
        int x1 = point[0], y1 = point[1];
        return Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));            
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int [][] r  = new int[k][2];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b.d,a.d);
        });
        
        for(int [] p : points){
            if(pq.size() < k){
                pq.add(new Pair(p,dist(p)));
            }else{
                if(dist(pq.peek().point) > dist(p)){
                    pq.poll();
                    pq.add(new Pair(p,dist(p)));
                }
            }
        }
        
        for(int i = 0;i < k ;i++){
            r[i] = pq.peek().point;
            pq.poll();
        }
        
        return r;
    }
}