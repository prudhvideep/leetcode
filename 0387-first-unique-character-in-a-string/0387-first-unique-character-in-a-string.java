class Solution {
    public int firstUniqChar(String s) {
        int [] count = new int[26];
        int n = s.length();
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(count[c-'a'] == 1)
                return i;
        }
        return -1;
    }
}