class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length-1;
        List <Integer> list = new ArrayList<>();

        while((h - l + 1) > k){
            if(Math.abs(arr[l] - x) <= Math.abs(arr[h] - x)){
                h--;
            }else{
                l++;
            }
        }

        for(int i = l;i <= h;i++){
            list.add(arr[i]);
        }

        return list;
    }
}