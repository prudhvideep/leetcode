class Solution {

    public long count(long cn,long nn,int n){
      long countNum = 0;

      while(cn <= n){
        countNum += (nn-cn);
        nn = nn*10;
        cn = cn*10;

        nn = Math.min(nn,n+1);
      }

      return countNum;
    }
    public int findKthNumber(int n, int k) {
      long  cn = 1,ct = 0;
      k-=1;
      while(k > 0){
        ct = count(cn,cn+1,n);

        if(ct <= k){
          k-=ct;
          cn+=1;
        }else{
          cn*=10;
          k-=1;
        }
      }  
      return (int) cn;      
    }

}