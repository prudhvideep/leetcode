class Solution {
    public boolean compare(int [] pc,int [] sc){
        for(int i = 0;i < 26;i++){
            if(pc[i] != sc[i])
                return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        String p,s;
          p = s1;
          s = s2;
        
        
        int pl = p.length(), sl = s.length();
        
        if(pl > sl)return false;
        
        int pc[] = new int[26];
        int sc[] = new int[26];
        
        
        for(int i =0;i < pl;i++){
            char c = p.charAt(i);
            pc[c-'a']++;
            
            char d = s.charAt(i);
            sc[d-'a']++;
        }
        
        if(compare(pc,sc)){
            return true;
        }
        
        int left = 0, right = pl;
        while(right < sl){
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            
            sc[lc-'a']--;
            sc[rc-'a']++;
            
            if(compare(pc,sc)){
                return true;   
            }
            left++;right++;
        }
        return false;
    }
}