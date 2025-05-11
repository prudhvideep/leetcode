class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
      Arrays.sort(boxTypes,(a,b) -> (b[1] - a[1]));

      int units = 0,boxes = 0;

      for(int [] box : boxTypes) {
        int nb = box[0];

        while(nb-- > 0) {
          if((boxes + 1) <= truckSize){
            units += box[1];
            boxes++;
          }else{
            break;
          }
        }
      }

      return units; 
    }
}