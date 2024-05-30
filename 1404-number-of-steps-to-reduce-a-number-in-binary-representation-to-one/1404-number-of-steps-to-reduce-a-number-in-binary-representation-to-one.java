class Solution {
    public int numSteps(String s) {
        int n = s.length(), c = 0, count = 0;
        // StringBuffer sb = new StringBuffer(s);
        
        int fi = 0;
        
        for(int i = n-1;i >= 0;i--){
            int num = s.charAt(i)-'0';
            
            if( (num+c)%2 == 0){
                count+= 1;
                
                if(num+c == 2){
                    c = 1;
                }else{
                    c = 0;
                }
            }else{
                if(i == 0)
                    continue;       
                
                count+= 2;
                
                c = 1;
            }
        }
        
        return  count;
    }
}
