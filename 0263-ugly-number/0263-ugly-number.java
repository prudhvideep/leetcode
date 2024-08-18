class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false; 

        int c2 = 0, c3 = 0, c5 = 0;

        int n2 = n, n3 = n, n5 = n;

        while(n2%2 == 0){
            n2 = n2/2;
            c2++;
        }

        while(n3%3 == 0){
            n3 = n3/3;
            c3++;
        }

        while(n5%5 == 0){
            n5 = n5/5;
            c5++;
        }

       int res = (int) Math.pow(2,c2);
       res *= (int) Math.pow(3,c3);
       res *= (int) Math.pow(5,c5);

       return res == n;
    }
}