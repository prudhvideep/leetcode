class Solution {
    public int integerBreak(int n) {
        if(n == 2 || n == 3)
            return n-1;
        
        if(n == 4)
            return n;
        
        int maxProd = 1;
        
        while(n > 4){
            n -= 3;
            maxProd = maxProd * 3;
        }
        
        maxProd = maxProd * n;
        
        return maxProd;
        
    }
}