class Solution {
    public int countSeniors(String[] details) {
        int count = (int) Arrays.stream(details)
                          .filter((x) -> {
                            int a = x.charAt(11) - '0';
                            int b = x.charAt(12) - '0';

                            a = (a * 10) + b;

                            if(a > 60) return true;

                            return false;
                          }).count();
        return count;
    }
}