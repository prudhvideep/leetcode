class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List <Integer> retList = new ArrayList<>();
        
        int id = -1;
        for(String word : words) {
          id++;

          for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == x){
              retList.add(id);
              break;
            }
          }
        }

        return retList;
    }
}