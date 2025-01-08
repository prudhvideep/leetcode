class Solution {
    public int countPrefixSuffixPairs(String[] words) {
      int count = 0;
      for(int i = 0;i < words.length;i++){
        for(int j = i+1; j < words.length;j++){
          if(isPrefixAndSuffix(words[i],words[j])){
            count++;
          }
        }
      }   

      return count;
    }

    public boolean isPrefixAndSuffix(String s1, String s2){
    
      return s2.startsWith(s1) && s2.endsWith(s1);

    }
}