class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str : details){
            if(Integer.parseInt(str.substring(11,13)) > 60){
                count++;
            }
        }

        return count;
    }
}