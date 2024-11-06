class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);

        int n = sb.length();

        while(n-- > 0){
          if(goal.compareTo(sb.toString()) == 0){
            return true;
          }

          char temp = sb.charAt(0);
          sb.deleteCharAt(0);
          sb.append(temp);
        }

        return false;
    }
}