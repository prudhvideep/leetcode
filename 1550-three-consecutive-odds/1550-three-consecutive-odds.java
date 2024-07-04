class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        for(int i : arr){
            if(i%2 == 0){
                count = 0;
            }else{
                count++;
                if(count == 3)
                    return true;
            }
        }
        return false;
    }
}