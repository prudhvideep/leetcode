class Solution {

  int count = 0;
  List<Integer> list = new ArrayList<>();

  public int countMaxOrSubsets(int[] nums) {
    int ms = nums[0];

    for (int i = 1; i < nums.length; i++) {
      ms |= nums[i];
    }

    findSubsets(0, list, nums,ms);

    return count;
  }

  public void findSubsets(int i, List<Integer> list, int[] nums, int ms) {
    if(list.size() > 0){
      int or = list.get(0);

      for(int j = 1;j < list.size();j++){
        or |= list.get(j);
      }

      if(or == ms){
        count++;
      }
    }
    for (int j = i;j < nums.length; j++) {
      list.add(nums[j]);
      findSubsets(j+1,list,nums,ms);
      list.remove(list.size()-1);
    }
  }
}