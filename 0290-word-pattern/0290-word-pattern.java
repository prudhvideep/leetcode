class Solution {
    public boolean wordPattern(String p, String s) {
        String [] sa = s.split(" ");
        
        if(sa.length != p.length())
            return false;
        
        HashMap<String,Integer> sM = new HashMap<>();
        HashMap<Character,Integer> pM = new HashMap<>();
        
        for(int i = 0;i < p.length();i++){
            if(!sM.getOrDefault(sa[i],0).equals(pM.getOrDefault(p.charAt(i),0)))
                return false;
            
            sM.put(sa[i],i+1);
            pM.put(p.charAt(i),i+1);
        }
        
        return true;
    }
}