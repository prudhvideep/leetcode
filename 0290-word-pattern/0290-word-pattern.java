class Solution {
    public boolean wordPattern(String p, String s) {
        String [] sa = s.split(" ");
        
        if(sa.length != p.length())
            return false;
        
        HashMap<String,Integer> sM = new HashMap<>(200);
        HashMap<Character,Integer> pM = new HashMap<>(200);
        
        for(int i = 0;i < p.length();i++){
            int a = sM.getOrDefault(sa[i],0);
            int b = pM.getOrDefault(p.charAt(i),0);
            if(a != b){
                return false;   
            }            
            sM.put(sa[i],i+1);
            pM.put(p.charAt(i),i+1);
        }
        
        return true;
    }
}