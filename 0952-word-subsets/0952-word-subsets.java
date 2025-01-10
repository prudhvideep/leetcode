class Solution {
    public int[] getCharCount(String word) {
      int [] count = new int[26];

      for(int i = 0;i < word.length();i++){
        int id = word.charAt(i)-'a';
        count[id]++;
      }

      return count;
    }

    public boolean checkSubset(int [] cw1, int [] cw2){
      for(int i = 0;i < 26;i++){
        if(cw1[i] < cw2[i]){
          return false;
        } 
      }

      return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> retList = new ArrayList<>();
        
        int [] mc = getCharCount(words2[0]);

        for(int i = 1; i < words2.length;i++){
          int [] cc = getCharCount(words2[i]);

          for(int j = 0;j < 26;j++){
            mc[j] = Math.max(mc[j],cc[j]);
          }
        }

        for(String w1 : words1){
          int [] wc = getCharCount(w1);

          if(checkSubset(wc,mc)){
            retList.add(w1);
          }
        }

        return retList;
    }
}