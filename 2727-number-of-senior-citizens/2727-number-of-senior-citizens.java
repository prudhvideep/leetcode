class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str : details){
           int a = str.charAt(11) - '0';
           int b = str.charAt(12) - '0';

           a = (a*10) + b;

           if(a > 60){
            count++;
           }
        }
        

        return count;
    }
}