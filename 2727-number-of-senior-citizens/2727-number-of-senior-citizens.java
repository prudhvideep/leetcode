class Solution {
    public int countSeniors(String[] details) {
        int count = (int) Arrays.stream(details)
                          .filter((x) -> {
                             if(Integer.parseInt(x.substring(11,13)) > 60){
                                return true;
                             }
                             return false;
                          }).count();
        return count;
    }
}