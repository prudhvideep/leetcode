class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int [] nge = getNge(height,n);
        int [] pge = getPge(height,n);
        
        
        int water = 0;
        for(int i = 0;i < n;i++){
           water += (Math.min(pge[i],nge[i]) - height[i]);
        }
        
        return water;
    }
    
    
    public int [] getPge(int [] height,int n){
        int [] pge = new int [n];
        pge[0] = height[0];
        
        for(int i = 1;i < n;i++){
            pge[i] = Math.max(height[i],pge[i-1]);
        }
        
        return pge;
    }
    
    public int [] getNge(int [] height,int n){
        
        int [] nge = new int [n];
        nge[n-1] = height[n-1];
        
        for(int i = n-2;i >= 0; i--){
            nge[i] = Math.max(height[i],nge[i+1]);
        }
        
        return nge;
    }
}