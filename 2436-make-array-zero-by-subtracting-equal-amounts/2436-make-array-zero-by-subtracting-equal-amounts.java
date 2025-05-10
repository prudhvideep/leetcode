class Solution {
    public int minimumOperations(int[] nums) {
       HashSet <Integer> hs = new HashSet<>();

       for (int num : nums) {
        if(num != 0)
          hs.add(num);
       } 

       return hs.size();
    }
}