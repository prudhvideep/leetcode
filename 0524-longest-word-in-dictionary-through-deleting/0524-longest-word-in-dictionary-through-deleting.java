class Solution {
    public boolean isSubSeq(String s, String dictStr){
        int i, j;
         i = 0; j = 0;
        while(i < s.length() && j < dictStr.length()){
                if(s.charAt(i) == dictStr.charAt(j)){
                    j++;
                }
                i++;
        }

        return j == dictStr.length();
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String retStr="";
        for(String dictStr : dictionary){
           if(isSubSeq(s,dictStr) && ((dictStr.length() > retStr.length()) 
            || ( (dictStr.length() == retStr.length()) && (dictStr.compareTo(retStr) < 0)))){
                retStr = dictStr;
            }
        }

        return retStr;
    }
}