class Solution {
  public int findMinDifference(List<String> timePoints) {
    Collections.sort(timePoints, (a, b) -> {
      String[] aInt = a.split(":");
      String[] bInt = b.split(":");

      int h1 = Integer.valueOf(aInt[0]);
      int h2 = Integer.valueOf(bInt[0]);

      if (h1 == h2) {
        int m1 = Integer.valueOf(aInt[1]);
        int m2 = Integer.valueOf(bInt[1]);

        return (m1 - m2);
      }

      return (h1 - h2);
    });

    int minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < timePoints.size() - 1; i++) {
      minDiff = Math.min(minDiff,getDiff(timePoints.get(i),timePoints.get(i+1)));
    }

    minDiff = Math.min(minDiff,getDiff(timePoints.get(0),timePoints.get(timePoints.size()-1)));

    return minDiff;
  }

  public int getDiff(String a,String b){
      String [] aCom = a.split(":");
      String [] bCom = b.split(":");

      int h1 = Integer.valueOf(aCom[0]);
      int h2 = Integer.valueOf(bCom[0]);

      

      int m1 = Integer.valueOf(aCom[1]);
      int m2 = Integer.valueOf(bCom[1]);

      // System.out.println("h1 " + h1 + " h2 " + h2 + " m1 " + m1 + " m2 " + m2); 

      int diff = 0;

      if(h1 == h2){

        diff = Math.abs(m1-m2);
      }else{
         int m2t_0 = (24 * 60);
         int h2t_0 = (h2 * 60) + (m2);

         int d1 = Math.abs(m2t_0 - h2t_0);
        
         int h10_t = (h1*60) + (m1);
         
         d1 += h10_t;

         int m10_t = (h1 * 60) + (m1);
         int m20_t = (h2 * 60) + (m2);

         int d2 = Math.abs(m20_t - m10_t);

        //  System.out.println("d1 " + d1 + " d2 " + d2);

         diff = Math.min(d1,d2);
      }

    //  System.out.println(diff);
     return diff;

    }
}