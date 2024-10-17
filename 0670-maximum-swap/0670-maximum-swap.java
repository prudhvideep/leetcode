class Solution {
    public int maximumSwap(int num) {
        ArrayList <Integer> al = new ArrayList<>();
        int n = num;

        while(n != 0){
          int r = n%10;
          al.add(r);
          n = n/10;
        }
        
        Collections.reverse(al);

        Pair [] p = new Pair[al.size()];

        for(int i = al.size()-1;i >= 0; i--){
          if(i == al.size()-1){
            p[i] = new Pair(al.get(i),i);
            continue;
          }

          if(al.get(i) <= p[i+1].n){
            p[i] = new Pair(p[i+1].n,p[i+1].i);
          }else{
            p[i] = new Pair(al.get(i),i);
          }
        }

        for(int i = 0;i < al.size();i++){
          if(al.get(i) < p[i].n){
            int temp = al.get(i);
            al.set(i,p[i].n);
            al.set(p[i].i,temp);
            break;
          }
        }

        int res = 0;

        for(int i : al){
          res = (res * 10) + i;
        }

        return res;
    }

    class Pair{
      int n;
      int i;
      Pair(int n,int i){
        this.n = n;
        this.i = i;
      }
    }
}