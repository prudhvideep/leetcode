class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        StringBuffer sb = new StringBuffer();
        
        for(int i = n-2;i >= 0;i--){
            shifts[i] = (shifts[i+1]+shifts[i])%26;
        }
        shifts[n-1] = shifts[n-1]%26;
        
        for(int i = 0; i < n;i++){
            int id = s.charAt(i) - 'a';
            
            id = (id+shifts[i])%26;
            
            char c = (char) ('a'+id);
            sb.append(c);
        }
        
        return sb.toString();
    }
}