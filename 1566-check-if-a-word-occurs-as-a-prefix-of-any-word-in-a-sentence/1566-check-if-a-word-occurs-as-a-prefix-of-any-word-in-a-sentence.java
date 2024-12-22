class Solution {
    public boolean isPrefix(String str,String word){
       if(word.length() > str.length()){
        return false;
       }

       for(int i = 0;i < word.length();i++){
        if(word.charAt(i) != str.charAt(i)){
          return false;
        }
       }
       return true;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String [] strs = sentence.split(" ");

        for(int i = 0; i < strs.length;i++){
          if(isPrefix(strs[i],searchWord)){
            return i+1;
          }
        }  

        return -1;      
    }
}

