class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        
        int [] suffix = new int[n];
        int [] prefix = new int[n];
        
        for(int i = n-1; i>=0;i--){
            suffix[i] = (i == (n-1))? nums[i] : suffix[i+1] + nums[i];
        }
        
        for(int i = 0; i < n;i++){
            prefix[i] = (i == 0)? nums[i] : prefix[i-1] + nums[i];
        }
        
        for(int i = 0;i < n;i++){
            if(i == 0 && suffix[i+1] == 0){
                    return i;
            }else if(i == n-1 && prefix[i-1] == 0){
                    return i;
            }else if(i != 0 && i != (n-1) && (prefix[i-1] == suffix[i+1])){
                    return i;
            }
            
        }
        
        return -1;
    }
}