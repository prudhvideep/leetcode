class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        if(n == 1)
            return heights[0];
            
        int [] nse = getNse(heights,n);
                
        int [] pse = getPse(heights,n);
        
        int l,h, maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            if(nse[i] == -1 && pse[i] == -1){
                maxArea = Math.max(maxArea, (n * heights[i]));
            }else if(pse[i] != -1 && nse[i] == -1){
                maxArea = Math.max(maxArea, ((n-pse[i]-1) * heights[i]));
            }else if(pse[i] == -1 && nse[i] != -1){
                maxArea = Math.max(maxArea, ((nse[i]-0) * heights[i]));
            }else{
                maxArea = Math.max(maxArea, ((nse[i] - pse[i] - 1) * heights[i]));
            }
        }
        
        return maxArea;
    }
    
    public int[] getNse(int [] heights, int n){
        int [] nse = new int[n];
        
        Stack <Pair> st = new Stack<>();
        st.push(new Pair(heights[0],0));
        
        for(int i = 1;i < n;i++){
            while(!st.isEmpty() && (st.peek().a > heights[i])){
                int id = st.peek().b;
                nse[id] = i;
                st.pop();
            }
            
            st.push(new Pair(heights[i],i));
        }
        
        while(!st.isEmpty()){
            int id = st.peek().b;
            nse[id] = -1;
            st.pop();
        }
        
        return nse;
    }
    
    public int[] getPse(int [] heights, int n){
        int [] pse = new int[n];
        
        Stack <Pair> st = new Stack<>();
        st.push(new Pair(heights[n-1],n-1));
        
        for(int i = n-2;i >= 0;i--){
            while(!st.isEmpty() && (st.peek().a > heights[i])){
                int id = st.peek().b;
                pse[id] = i;
                st.pop();
            }
            
            st.push(new Pair(heights[i],i));
        }
        
        while(!st.isEmpty()){
            int id = st.peek().b;
            pse[id] = -1;
            st.pop();
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