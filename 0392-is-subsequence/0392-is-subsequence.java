class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        
        if(m > n)return false;
        
        int left = 0, right = 0;
        
        while(left < m && right < n){
            if(s.charAt(left) == t.charAt(right)){
                left++;
                right++;
            }else{
                right++;
            }
        }
        
        return (left == m);
    }
}