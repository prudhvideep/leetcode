class Solution {
    public int minimumLength(String s) {
        char ch[] = s.toCharArray();
        int l = 0, h = ch.length-1;
        
        while(l < h){
            if(ch[l] != ch[h])break;
            char c = ch[l];
            while(h>=l && ch[l]==c)l++;
                             
            while(h>=l && ch[h] == c)h--;
        }
        return h-l+1;
    }
}