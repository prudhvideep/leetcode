class Solution {
    public String largestNumber(int[] nums) {
        
        int n = nums.length;
        String [] strArr = new String[n];
        
        for(int i = 0;i < n;i++){
            strArr[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(strArr, new Comparator<>(){
            public int compare(String a, String b){
                String x = a+b;
                String y = b+a;
                return y.compareTo(x);
            }
        });
        StringBuffer sb = new StringBuffer();
        
        for(String s : strArr){
            sb.append(s);
        }
        if(sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}