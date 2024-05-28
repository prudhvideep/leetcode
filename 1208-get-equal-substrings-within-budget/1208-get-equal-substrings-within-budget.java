class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int sl = s.length(), tl = t.length();
        
        int l = 0, curCost = 0, maxLen = 0;
        
        for(int h = 0;h < sl;h++){
            curCost += Math.abs(s.charAt(h)-t.charAt(h));
            
            while(l <= h && curCost > maxCost){
                curCost -= (Math.abs(s.charAt(l)-t.charAt(l)));
                l++;
            }
            
            maxLen = Math.max(maxLen,(h-l+1));
        }
        
        return maxLen;
    }
}