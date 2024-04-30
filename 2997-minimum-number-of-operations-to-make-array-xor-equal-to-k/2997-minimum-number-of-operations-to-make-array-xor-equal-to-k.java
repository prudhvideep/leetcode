class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int [] kBarr = genBinarr(k);
        
        int [] numSum = genBinarr(nums[0]);
        
        for(int i = 1;i < nums.length;i++){
            int [] temp = genBinarr(nums[i]);
            
            for(int j = 0;j < 32;j++){
                numSum[j] += temp[j];
            }
        }

        int op = 0;
        
        for(int i = 0; i < 32;i++){
            int oneCount = numSum[i];
            if(kBarr[i] == 1 && (oneCount % 2) == 0){
                op++;
            }else if(kBarr[i] == 0 && (oneCount % 2) == 1){
                op++;
            }
        }
        
        return op;
    }
    
    int [] genBinarr(int n){
        int [] a = new int [32];
        int mask = 0;
        for(int i = 0;i < 32;i++){
            mask = 1 << i;
            
            a[i] = (n & mask)/mask;
        }
        
        return a;
    }
}