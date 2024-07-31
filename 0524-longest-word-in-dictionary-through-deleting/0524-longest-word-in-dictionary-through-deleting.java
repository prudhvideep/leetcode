class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        int i, j;
        String retStr="";
        for(String dictStr : dictionary){
            i = 0; j = 0;
            while(i < s.length() && j < dictStr.length()){
                if(s.charAt(i) == dictStr.charAt(j)){
                    j++;
                }
                i++;
            }
            if(j == dictStr.length()) {
                
                if(dictStr.length() > retStr.length()){
                    retStr = dictStr;
                }else if(dictStr.length() == retStr.length()){
                    
                    for(int k = 0;k < dictStr.length();k++){
                        if(dictStr.charAt(k) == retStr.charAt(k))
                            continue;

                        if(dictStr.charAt(k) < retStr.charAt(k)){
                            
                            retStr = dictStr;
                            break;
                        }else if(dictStr.charAt(k) > retStr.charAt(k)){
                            break;
                        }
                    }
                }
                
            }
        }

        return retStr;
    }
}