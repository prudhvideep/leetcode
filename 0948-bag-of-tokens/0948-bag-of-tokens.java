class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        
        Arrays.sort(tokens);
        int l = 0, h = tokens.length-1;
        
        while(l <= h){
            if(power >= tokens[l]){
                score+=1;
                power-=tokens[l];
                l++;
            }else if(l < h && score > 0){
                score-=1;
                power+=tokens[h];
                h--;
            }else{
                return score;
            }
        }
        
        return score;
    }
}