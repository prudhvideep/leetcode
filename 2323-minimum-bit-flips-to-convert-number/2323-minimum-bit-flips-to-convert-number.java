class Solution {
    public int minBitFlips(int start, int goal) {
        int s[] = getarr(start);
        int g[] = getarr(goal);
        
        int flips = 0;
        for(int i = 0;i < 32;i++){
            if(s[i] != g[i]){
                flips++;
            }
        }
        
        return flips;
    }
    
    int [] getarr(int n){
        int mask = 1;
        int [] a = new int[32];
        
        for(int i = 0;i < 32;i++){
            mask = 1 << i;
            a[i] = (n & mask)/mask;
        }
        
        return a;
    }
}