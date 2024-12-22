class Solution {
    public boolean checkIfExist(int[] arr) {
      for (int i = 0; i < arr.length; i++){
        int id = find(arr,arr[i]);
        if(id != -1 && id != i){
          return true;
        }
      }
      return false;
    }

    public int find(int [] a,int e){
      for(int i = 0;i < a.length;i++){
        if(a[i]*2 == e){
          return i;
        }
      }

      return -1;
    }
}