class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        
        boolean seive[] = new boolean[n+1];
        Arrays.fill(seive,true);
            
        for(int i = 2;i <= n;i++){
            if(seive[i] == true){
                int count = 2;
                while(i * count <= n){
                    seive[i * count] = false;
                    count++;
                }
            }
        }
        
        int nPrime = 0;
        for(int i = 2;i < n;i++){
            if(seive[i] == true)
                nPrime++;
        }
        
        return nPrime;
    }
}