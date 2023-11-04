class Solution {
    public int search(int[] a, int target) {
        
        int l = 0, h = a.length-1, mid;
        
        while(l <= h){
            mid = l + ((h-l)/2);
            if(a[mid] == target)
                return mid;
            if(a[mid] < target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        
        return -1;
    }
}