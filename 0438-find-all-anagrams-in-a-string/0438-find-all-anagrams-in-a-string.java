class Solution {
    public boolean compare(int [] pc, int [] sc){
        for(int i = 0;i < 26;i++){
            if(pc[i] != sc[i])
                return false;
        }
        return true;
    }    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        
        int [] pc = new int[26];
        int [] sc = new int [26];
        
        for(int i = 0;i < pl;i++){
            char c = p.charAt(i);
            pc[c - 'a']++;
        }
        
        for(int i = 0;i < sl-pl+1; i++){
            Arrays.fill(sc,0);
            for(int j = i;j < pl+i;j++){
                char c = s.charAt(j);
                int id = c-'a';
                
                if(pc[id] == 0){
                    break;
                }
                sc[id]++;
            }
            
            if(compare(pc,sc))
                list.add(i);
        }
        
        return list;
    }
}