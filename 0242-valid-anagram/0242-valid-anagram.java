class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int [] a = new int[26];
        int [] b = new int[26];
        
        for(int i = 0;i < s.length();i++){
            a[s.charAt(i)-'a']++;
            
            b[t.charAt(i)-'a']++;
        }
        
        for(int j = 0;j < 26;j++){
            if(a[j] != b[j])
                return false;
        }
        return true;
    }
}