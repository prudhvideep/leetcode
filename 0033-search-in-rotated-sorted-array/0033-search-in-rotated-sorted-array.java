class Solution {
    public int search(int[] nums, int target) {
        
        int k = findPivot(nums);
                    
        if(k == -1)
            return binarySearch(nums,target,0,nums.length-1);
        
        int a  = binarySearch(nums,target,0,k-1);
        
        
        if(a != -1) return a;
        
        int b = binarySearch(nums,target,k,nums.length-1);
        
        return b;
    }
    
    public int binarySearch(int [] a, int target,int l, int h){
        int mid;
        while(l <= h){
            mid = l + (h-l)/2;
            
            if(a[mid] == target){
                return mid;
            }else if(a[mid] > target){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return -1;
    }
    
    public int findPivot(int [] a){
        int l = 0, h = a.length-1, mid;
        
        while(l <= h){
            mid = (l+h)/2;
                    
            if(mid-1 >=0 && a[mid] < a[mid-1]){
                return mid;
            }else if(a[mid] >= a[0]){
                l = mid+1;
            }else if(a[mid] < a[0]){
                h = mid-1;
            }
        }
        
        return -1;
    }
}