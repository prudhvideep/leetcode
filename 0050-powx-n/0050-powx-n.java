class Solution {
    public double myPow(double x, int n) {
       if(n == 0)
           return 1;
       if(n == 1)
           return x;
       
        if(n < 0)
            return 1/(x*myPow(x,(-n-1)));
        
        if(n%2 == 0){
            double a  = myPow(x,n/2);
            return a*a;
        }
        
        return (myPow(x,n-1) * x);
    }
}