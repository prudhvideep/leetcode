import java.math.BigInteger;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, maxE = findMax(nums), l = 0, h = 0;
        
        long countArr = 0, c = 0;

        BigInteger nBigInt = BigInteger.valueOf(n);
        BigInteger nPlusOne = nBigInt.add(BigInteger.ONE);
        BigInteger totArr = nBigInt.multiply(nPlusOne).divide(BigInteger.valueOf(2));

        
        while(h < n){
            if(nums[h] == maxE)
                c++;
            
            while(c >= k && (l <= h)){
                if(nums[l] == maxE){
                    c--;
                }
                
                l++;
            }
                
            countArr += (h-l+1);
            h++;
        }
        
        totArr = totArr.subtract(BigInteger.valueOf(countArr));
        
        return totArr.longValue();
        
    }
    
    public int findMax(int [] nums){
        int maxE = Integer.MIN_VALUE;
        
        for(int i : nums){
            
            maxE = Math.max(maxE,i); 
        }
        
        return maxE;
    }
}