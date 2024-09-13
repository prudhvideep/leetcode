class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0, end = 0;
        List<String> list = new ArrayList<>();

        while(end < nums.length){
          if((end+1 < nums.length) && (nums[end+1] - nums[end] == 1)){
            end++;
            continue;
          }else{
            StringBuilder sb = new StringBuilder();
            if(start != end){
              sb.append(nums[start]);
              sb.append("->");
              sb.append(nums[end]);
            }else{
              sb.append(nums[start]);
            }
            list.add(sb.toString());
            end++;
            start=end;
          }
        }

        return list;
    }
}