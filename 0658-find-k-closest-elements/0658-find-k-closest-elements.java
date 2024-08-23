class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length - 1, n = arr.length,diff=Integer.MAX_VALUE,id = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            if(Math.abs(arr[i] - x) < diff){
                diff = Math.abs(arr[i] - x);
                id = i;
            }
        }
        list.add(arr[id]);
        l = id-1;
        h = id+1;

        while ((list.size() < k) && (l >= 0) && (h < n)) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[h])) {
                list.add(arr[l]);
                l--;
            } else {
                list.add(arr[h]);
                h++;
            }
        }

        while (list.size() < k && l >= 0 && h >= n) {
            list.add(arr[l]);
            l--;
        }

        while (list.size() < k && l < 0 && h < n) {
            list.add(arr[h]);
            h++;
        }
        Collections.sort(list);
        return list;
    }
}