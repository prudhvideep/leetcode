class Solution {
    public int longestPalindrome(String s) {
        int [] a = new int[128];
        
        for(char c : s.toCharArray()){
            a[c]++;
        }
        
        int l = 0;
        for(int i : a){
            l+=  i/2 * 2;
            if(l % 2 == 0 && i%2 == 1)
                l++;
        }
        return l;
        
    }
}