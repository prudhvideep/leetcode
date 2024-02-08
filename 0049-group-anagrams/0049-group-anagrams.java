class Solution {
    public String getCount(String str){
        StringBuffer sb = new StringBuffer();
        int a[] = new int[26];
        for(char c : str.toCharArray()){
            a[c-'a']++;
        }
        
        int count = 0;
        for(int i = 0;i < 26;i++){
            count = a[i];
            int temp = ((int) 'a') + i;
            char c = (char) temp;
            while(count-- > 0){
                sb.append(c);
            }
        }
        
        return sb.toString();
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