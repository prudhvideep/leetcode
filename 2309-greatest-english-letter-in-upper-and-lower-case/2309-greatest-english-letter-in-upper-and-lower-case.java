class Solution {
    public String greatestLetter(String s) {
        int [] lc = new int[26];
        int [] uc = new int[26];
        
        for(int i = 0;i < s.length();i++){
            char  c = s.charAt(i);
            
            if(Character.isLowerCase(c)){
                lc[c-'a']++;
            }else{
                uc[c-'A']++;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        char c;
        for(int i = 25; i>=0; i--){
            if(lc[i] > 0 && uc[i] > 0){
                c = (char) ('A' + i);
                sb.append(c);
                break;
            }
        }
    
        return sb.toString();
    }
}