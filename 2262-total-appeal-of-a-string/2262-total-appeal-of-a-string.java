class Solution {
    public long appealSum(String s) {
        long tot = 0, cur = 0;
        
        int [] pos = new int[26];
        
        for(int i = 0;i < s.length();i++){
            int id = s.charAt(i)-'a';
            cur += i - pos[id]+1;
            pos[id] = i+1;
            tot+=cur;
        }
        
        return tot;
    }
}