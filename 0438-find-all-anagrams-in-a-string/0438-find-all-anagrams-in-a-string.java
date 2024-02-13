class Solution {
    public boolean compare (int []pc,int []sc){
        for(int i = 0;i < 26;i++){
            if(pc[i] != sc[i])
                return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> list = new ArrayList<>();
        
        int sl = s.length(), pl = p.length();
        
        if(pl > sl)
            return list;
        
        int sc[] = new int[26];
        int pc[] = new int[26];
        
        for(int i = 0;i < pl;i++){
            char c = p.charAt(i);
            pc[c-'a']++;
            
            char d = s.charAt(i);
            sc[d-'a']++;
        }
        
        if(compare(pc,sc)){
            list.add(0);
        }
        
        int left = 0, right = pl;
        
        while(right < sl){
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            
            sc[lc-'a']--;
            sc[rc-'a']++;
            
            if(compare(pc,sc)){
                list.add(left+1);
            }
            
            left++;
            right++;
        }
        
        return list;
    }
}