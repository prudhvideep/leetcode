class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        if(n == 1)
            return heights[0];
            
        int [] nse = getNse(heights,n);
                
        int [] pse = getPse(heights,n);
        
        int l,h, maxArea = 0;
        
        for(int i = 0; i < n; i++){
            
                maxArea = Math.max(maxArea, ((nse[i] - pse[i] - 1) * heights[i]));
    
        }
        
        return maxArea;
    }
    
    public int[] getNse(int [] heights, int n){
        int [] nse = new int[n];
        
        nse[n - 1] = n;
        
        for(int i = n-2;i >= 0;i--){
            int p = i+1;
            
            while(p < n && heights[p] >= heights[i]){
                p = nse[p];
            }
            nse[i] = p;
        }
        
        return nse;
    }
    
    public int[] getPse(int [] heights, int n){
        int [] pse = new int[n];
        
        pse[0] = -1;
        
        for(int i = 1;i < n;i++){
            int p = i-1;
            
            while(p >= 0 && heights[p] >= heights[i]){
                p = pse[p];
            }
            pse[i] = p;
        }
        
        return pse;
    }
    
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}