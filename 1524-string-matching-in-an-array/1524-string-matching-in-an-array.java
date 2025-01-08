class Solution {
    public List<String> stringMatching(String[] words) {
        Set <String> ret = new HashSet<>();

        for(int i = 0;i < words.length;i++) {
          for(int j = i+1; j < words.length;j++){
            if(words[i].contains(words[j])){
              ret.add(words[j]);
            }else if(words[j].contains(words[i])){
              ret.add(words[i]);
            }
          }
        }

        List <String> list = new ArrayList<>();
        list.addAll(ret);

        return list;
    }
}