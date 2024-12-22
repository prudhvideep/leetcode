class Solution {
    public boolean checkIfExist(int[] arr) {
       int cZero = 0;

       for (int ele : arr) {
          if(ele == 0){
            cZero++;
          }

          if(cZero > 1) return true;
       }

        Set <Integer> set = new HashSet<>();
        Set <Integer> dset = new HashSet<>();

        for( int ele : arr ){
          set.add(ele);
          dset.add(2*ele);
        }

        for (int ele : set){
          if(dset.contains(ele) && ele != 0){
            return true;
          }
        }

        return false;
    }
}