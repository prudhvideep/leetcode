class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        
        HashMap <Character,Integer> hm = new HashMap<>();
        
        int l = 0, h = 0, maxLen = Integer.MIN_VALUE;
        
        while(h < s.length()){
            char c = s.charAt(h);
            if(!hm.containsKey(c)){
                hm.put(c,h);                
            }
            else{
                l = Math.max(hm.get(c)+1,l);
                hm.put(c,h);
            }
                
            maxLen = Math.max(maxLen,(h-l+1));
            h++;
        }
        return maxLen;
    }
}