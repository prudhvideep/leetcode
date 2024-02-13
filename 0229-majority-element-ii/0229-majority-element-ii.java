class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List <Integer> list = new ArrayList<Integer>();
        
        int m1 = 0, m2 = 0, n1 = 0, n2 = 0, n = nums.length;
        
        for(int i = 0;i < n;i++){
            if(nums[i] == m1){
                n1++;
            }else if(nums[i] == m2){
                n2++;
            }else if(n1 == 0){
                m1 = nums[i];
                n1 = 1;
            }else if(n2 == 0){
                m2 = nums[i];
                n2 = 1;
            }else{
                n1--;
                n2--;
            }
        }
        
        int rf = n/3, count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == m1){
                count1++;
            }
            
            if(nums[i] == m2){
                count2++;
            }
        }
        
        if(count1 > rf){
            list.add(m1);
            if(m1 == m2){
                return list;
            }
        }
        if(count2 > rf){
            list.add(m2);
        }
        return list;
    }
}