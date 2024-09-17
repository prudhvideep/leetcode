class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String a1 [] = s1.split(" ");
        String a2 [] = s2.split(" ");

        HashMap <String,Integer> hm = new HashMap<>();

        for(String s : a1){
          hm.put(s,hm.getOrDefault(s,0)+1);
        }

        for(String s : a2){
          hm.put(s,hm.getOrDefault(s,0)+1);
        }

        ArrayList <String> list = new ArrayList<>();

        for(String key : hm.keySet()){
          if(hm.get(key) == 1){
            list.add(key);
          }
        }

        String [] ret = list.stream().toArray((s) -> new String[s]);

        return ret; 
    }
}