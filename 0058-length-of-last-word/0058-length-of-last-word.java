class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int l = -1, h = 0;
        char c;
        
        for(int i = n-1;i >= 0;i--){
            c = s.charAt(i);
            
            if(l == -1 && c == ' ')
                continue;
            
            if(l == -1)l = i;
            
            if(l != -1 && c == ' ')break;
            
            h = i;
        }
        
        return (l-h+1);
    }
}