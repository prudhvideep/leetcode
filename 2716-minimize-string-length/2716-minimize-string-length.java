class Solution {
    public int minimizedStringLength(String s) {
        boolean [] ch = new boolean[26];
        for(char c : s.toCharArray()){
            if(!ch[c-'a']){
                ch[c-'a'] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < 26;i++){
            if(ch[i]){count++;}
        }
        return count;
    }
}