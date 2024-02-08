class Solution {
    public String getCount(String str){
        char [] ca = str.toCharArray();
        Arrays.sort(ca);
        String retStr = new String(ca);
        
        return retStr;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        
        Map<String,List<String>> mp = new HashMap<>();
        
        for(int i = 0;i < strs.length;i++){
            String tempStr =  getCount(strs[i]);
            if(!mp.containsKey(tempStr)){
                mp.put(tempStr,new ArrayList<String>());
                
            }
            mp.get(tempStr).add(strs[i]);
        }
        
        for(Map.Entry<String,List<String>> me : mp.entrySet()){
            ret.add(me.getValue());
        }
        
        return ret;
    }
}