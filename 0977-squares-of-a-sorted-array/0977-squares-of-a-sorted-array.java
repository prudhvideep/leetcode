class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, h = nums.length-1,a,b;
        int [] ret = new int[nums.length];
        
        int i = nums.length-1;
        
        while(l <= h){
            a = nums[l] * nums[l];
            b = nums[h] * nums[h];
            
            if(a >= b){
                ret[i] = a;
                l++;
            }else{
                ret[i] = b;
                h--;
            }
            i--;
        }
        return ret;
    }
}