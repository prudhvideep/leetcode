class Solution {
  public String largestNumber(int[] nums) {
        nums = Arrays.stream(nums)
        .boxed()
        .sorted( (a,b) -> {
         String x = a.toString() + b.toString();
         String y = b.toString() + a.toString();

         return y.compareTo(x);
        }).mapToInt((x) -> x.intValue()).toArray();

        StringBuilder sb = new StringBuilder();

        for(int i : nums){
          sb.append(i);
        }

        if(sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}