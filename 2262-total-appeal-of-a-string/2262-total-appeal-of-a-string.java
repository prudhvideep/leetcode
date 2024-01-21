class Solution {
    public long appealSum(String s) {
        long curApp = 0, totApp = 0;
        int pos [] = new int[26];
        
        for(int i = 0;i < s.length();i++){
            int id = s.charAt(i) - 'a';
            
            curApp += i - pos[id] + 1;
            pos[id] = i+1;
            totApp += curApp;
        }
        return totApp;
    }
}