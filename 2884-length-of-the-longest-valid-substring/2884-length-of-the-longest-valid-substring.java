class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set <String> set = new HashSet<>();
        set.addAll(forbidden);

        int i = 0, j = 0,maxLen = 0,k;

        while(j < word.length()){
           for(k = j; k > j-10 && k>=i ;k--){
                String subStr = word.substring(k,j+1);
                if(set.contains(subStr)){
                    i = k+1;
                    break;
                }
           }

                maxLen = Math.max(maxLen,(j-i+1));
                j++;
           
        }

        return maxLen;
    }
}