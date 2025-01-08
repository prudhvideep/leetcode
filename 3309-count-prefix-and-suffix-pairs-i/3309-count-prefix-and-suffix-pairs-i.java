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
      boolean isPrefix = true, isSuffix = true;
      int l1 = s1.length(), l2 = s2.length();

      if(s1.length() > s2.length()) return false;
      
      for(int i = 0;i < s1.length();i++){
        if(s1.charAt(i) != s2.charAt(i)){
          isPrefix = false;
        }
        
        if(s1.charAt(l1-i-1) != s2.charAt(l2-i-1)){
          isSuffix = false;
        }
        
      }

      // for(int j = s2.length()-1;j > s2.length()-s1.length(); j--){
      //     if(s1.charAt(j-s1.length()) != s2.charAt(j)){
      //       isSuffix = false;
      //     }
      // }


      return isPrefix && isSuffix;

    }
}