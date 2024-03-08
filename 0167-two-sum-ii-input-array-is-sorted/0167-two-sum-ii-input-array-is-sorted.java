class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length-1;
        
        while(l < h){
            if(numbers[l]+numbers[h] == target){
                return new int[] {l+1,h+1};
            }else if(numbers[l]+numbers[h] < target){
                l++;
            }else {
                h--;
            }
        }
        
        return new int[] {l+1,h+1};
    }
}