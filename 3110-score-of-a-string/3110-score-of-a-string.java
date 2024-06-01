class Solution {
    public int scoreOfString(String s) {
        int n = s.length(), score = 0;
        
        for(int i = 0;i < n-1;i++){
            int a = (int) s.charAt(i);
            int b = (int) s.charAt(i+1);
            
            score += Math.abs(a-b);
        }
        
        return score;
    }
}