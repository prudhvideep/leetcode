class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(nums[i]%2 == 0){
                hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            }
        }
        
        int maxf = -1, ele = -1;
        
        for(Map.Entry<Integer,Integer> me : hm.entrySet()){
            int f = me.getValue();
            int e = me.getKey();
            //System.out.println("f : " + f);
            //System.out.println("e : " + e);
            if(f > maxf){
                maxf = f;
                ele = e;
            }else if(f == maxf){
                if(ele > e){
                    ele = e;
                }
            }
        }
        
        return ele;
    }
}