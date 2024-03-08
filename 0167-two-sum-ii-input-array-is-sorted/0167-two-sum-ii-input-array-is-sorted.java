class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length-1;
        
        while(l < h){
            if(numbers[l]+numbers[h] == target){
                break;
            }else if(numbers[l]+numbers[h] < target){
                l++;
            }else if(numbers[l]+numbers[h] > target){
                h--;
            }
        }
        
        return new int[] {l+1,h+1};
    }
}