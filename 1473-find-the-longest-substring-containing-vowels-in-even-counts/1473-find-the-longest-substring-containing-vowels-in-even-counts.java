class Solution {
    public int findTheLongestSubstring(String s) {
        int mask = 0, maxLen = 0;
        HashMap <Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);

        for(int i = 0;i < s.length();i++){
          switch(s.charAt(i)){
            case 'a':
              mask ^= (1 << 0);
            case 'e':
              mask ^= (1 << 1);
            case 'i':
              mask ^= (1 << 2);
            case 'o':
              mask ^= (1 << 3);
            case 'u':
              mask ^= (1 << 4);
          }

          if(hm.containsKey(mask)){
            maxLen = Math.max(maxLen,(i-hm.get(mask)));
          }else{
            hm.put(mask,i);
          }
        }
        return maxLen;
    }
}