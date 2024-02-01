class Solution {
    public int appendCharacters(String s, String t) {
        int n = t.length(), m = s.length(), i = 0, j = 0;
        
        while(i < n && j < m){
            if(t.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        int ac = n - i;
        
        return ac;
    }
}