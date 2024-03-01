class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0;i < n;i++){
            sb.append("0");
        }
        
        int zCount = 0;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == '1'){
                zCount++;
            }
        }
        
        sb.setCharAt(n-1,'1');
        zCount--;
        
        
        if(zCount > 0){
            int i = 0;
            while(zCount > 0){
                sb.setCharAt(i,'1');
                i++;
                zCount--;
            }
        }
        
        return sb.toString();
    }
}