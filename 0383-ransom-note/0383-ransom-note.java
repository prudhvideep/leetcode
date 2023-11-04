class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[26];
        
        for(int i = 0;i < magazine.length();i++){
            char c = magazine.charAt(i);
            a[c-'a']++;
        }
        
        for(int i = 0;i < ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(a[c-'a'] <= 0)
                return false;
            
            a[c-'a']--;
        }
        return true;
    }
}