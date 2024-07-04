class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap <Integer,Integer> hm = new HashMap <> ();
        ArrayList <Integer> result = new ArrayList <> ();
        
        for(int num : nums1){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        int count = 0;
        for(int num : nums2){
            count = hm.getOrDefault(num,0);
            if(count > 0){
                result.add(num);
                count--;
                hm.put(num,count);
            }
        }
        
        int resArr [] = new int[result.size()];
        
        for(int i = 0;i < result.size();i++){
            resArr[i] = result.get(i);
        }
        
        return resArr;
    }
}