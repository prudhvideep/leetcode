class Solution {
    public int pivotInteger(int n) {
        int [] prefix = new int[n+1];
        
        for(int i = 1;i <= n;i++){
            prefix[i] = (i == 1) ? 1 : prefix[i-1]+i; 
        }
        
        for(int i = 1; i<= n; i++){
            if(prefix[i] == (prefix[n] - prefix[i-1]))
                return i;
        }
        return -1;
    }
}