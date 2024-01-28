class Solution {
    public int numSquares(int n) {
        ArrayList <Integer> al;
        al = genArrList(n);
        
        int [][] dp = new int[al.size()][n+1];
        
        for(int i = 0; i < al.size();i++){
            dp[i][0] = 0;
        }
        
        for(int j = 0;j <= n;j++){
            dp[0][j] = j;
        }
        
        for(int i = 1;i < al.size(); i++){
            for(int j = 1;j <= n;j++){
                if(al.get(i) > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(1+dp[i][j-al.get(i)],dp[i-1][j]);
                }
            }
        }
        
        
        return dp[al.size()-1][n];
    }
    
    ArrayList<Integer> genArrList(int n){
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        int i = 1;
        
        while( i*i <= n){
            al.add(i*i);
            i++;
        }
        
        return al;
    }
}