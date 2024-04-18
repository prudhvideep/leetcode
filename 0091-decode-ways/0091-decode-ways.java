class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int [n];
        
        String temp = s.substring(n-1,n);
        int a  = Integer.valueOf(temp);
                
        if(a >= 1 && a <= 9){
            dp[n-1] = 1;
        }else{
            dp[n-1] = 0;
        }
        
        for(int i = n-2;i >=0 ;i--){
            int sum = 0;
            
            for(int j = i; j < n;j++){
                boolean isValid = false;
                String prefix = s.substring(i,j+1);
                
                int prefix_int = -1;
                
                if(prefix.length() < 3){
                    prefix_int = Integer.valueOf(prefix);
                }else{
                    break;
                }
                
                if(prefix_int == 0){
                    dp[i] = 0;
                    break;
                }
                    
                if(prefix_int >= 1 && prefix_int <= 26){
                    isValid = true;
                }
                
                if(isValid){
                    if(j == n-1){
                        sum+=1;
                    }else{
                        sum+=dp[j+1];
                    }
                }
            }
            dp[i] = sum;
        }
        return dp[0];
    }
}