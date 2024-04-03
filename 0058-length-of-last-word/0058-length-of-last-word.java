class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String [] strings = s.split("\\s+");
        
        int n = strings.length;
        
        return strings[n-1].length();
        
    }
}