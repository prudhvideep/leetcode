class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set <String> set = new HashSet();

        for(String num : nums) {
          set.add(num);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n;i++) {
          sb.append('0');
        }


        while(true) {
          if(!set.contains(sb.toString())){
            return sb.toString();
          }

          addOne(sb);
        }

        
    }

    public void addOne(StringBuilder sb) {
      int c = 0;
      for(int i = sb.length()-1;i >= 0;i--) {
        int ch = sb.charAt(i) - '0';

        if(i == sb.length()-1) {
          ch += 1;
        }else{
          if(c == 0) {
            break;
          }
        }

        ch += c;
        c = ch/2;
        ch = ch%2;

        sb.setCharAt(i,(char)('0' + ch));
      }
    }
}