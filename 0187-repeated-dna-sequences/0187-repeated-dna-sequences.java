class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List <String> ret = new ArrayList<>();
        Map <String,Integer> hm = new HashMap<>();

        if(s.length() <= 10)
            return ret;

        for(int i = 0;i < (s.length()-10+1);i++){
            String subStr = s.substring(i,i+10);
            hm.put(subStr,hm.getOrDefault(subStr,0)+1);
        }

        for(String key : hm.keySet()){
            if(hm.get(key) > 1){
                ret.add(key);
            }
        }

        return ret;
    }
}