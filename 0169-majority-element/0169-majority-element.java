class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, majEle = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == majEle){
                count++;
            }else{
                count--;
                if(count == 0){
                    majEle = nums[i];
                    count++;
                }
            }
        }
        
        return majEle;
    }
}