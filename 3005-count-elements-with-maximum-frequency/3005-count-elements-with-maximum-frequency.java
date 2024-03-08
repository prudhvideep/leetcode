class Solution {
    public int maxFrequencyElements(int[] nums) {
        int count [] = new int[101], mf = Integer.MIN_VALUE;
        
        for(int i : nums){
            count[i]++;
            mf = Math.max(mf,count[i]);
        }
        
        int sum = 0; 
        for(int j = 1; j<=100;j++){
            if(count[j] == mf){
               sum+=count[j]; 
            }
        }
        
        return sum;
    }
}