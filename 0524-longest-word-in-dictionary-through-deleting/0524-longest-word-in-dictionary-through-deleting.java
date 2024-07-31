class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a,b) -> {
            if(a.length() == b.length()){
                for(int i = 0;i < a.length();i++){
                    if(a.charAt(i) != b.charAt(i)){
                        int aVal = a.charAt(i)-'a';
                        int bVal = b.charAt(i)-'a';

                        return aVal - bVal;
                    }
                }
            }

            return (b.length()-a.length());
        });
        
        int i, j;
        for(String dictStr : dictionary){
            i = 0; j = 0;
            while(i < s.length() && j < dictStr.length()){
                if(s.charAt(i) == dictStr.charAt(j)){
                    j++;
                }
                i++;
            }
            if(j == dictStr.length()) return dictStr;
        }

        return new String("");
    }
}