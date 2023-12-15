class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        
        int minLen = -1;
        
        
        for(int i = 0;i < strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j = 0;j < strs.length;j++){
               // if(strs[j].length() == 0)
               //     return "";
                
               // System.out.println("Strlen : " + strs[j].length());
               // System.out.println("index : " + i);
                
                if(i >= strs[j].length())
                    return sb.toString();
                
                if(strs[j].charAt(i) != c)
                    return sb.toString();
            }   
            sb.append(c);
        }
        return sb.toString();
    }
}