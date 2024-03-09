class Solution {
    public int trailingZeroes(int n) {
        if(n <= 4)
            return 0;
        
        int a = n, b = 2, sum2 = 0;
        while((a/b) != 0){
            sum2+= (a/b);
            b*=2;
        }
        
        int c = n, d = 5, sum5 = 0;
        while((c/d) != 0){
            sum5+= (c/d);
            d*=5;
        }
        
        return Math.min(sum2,sum5);
    }
}