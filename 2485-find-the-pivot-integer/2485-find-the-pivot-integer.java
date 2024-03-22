class Solution {
    public int pivotInteger(int n) {
        int sum = (n*(n+1))/2, cs = 0;
        
        for(int i = 1;i <= n;i++){
            cs += i;
            
            if((sum-cs+i) == cs)
                return i;
        }
        return -1;
    }
}