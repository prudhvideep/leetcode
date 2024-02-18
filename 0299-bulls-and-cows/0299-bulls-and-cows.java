class Solution {
    public String retString(int nb,int nc){
        StringBuffer sb = new StringBuffer();
        sb.append(nb);
        sb.append('A');
        sb.append(nc);
        sb.append('B');
        
        return sb.toString();
    }
    public String getHint(String secret, String guess) {
        int [] count = new int[10];
        int n = secret.length(),nb = 0,nc = 0;
        
        for(int i = 0;i < n;i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s == g){
                nb++;
            }else{
                if(count[s-'0']++ < 0){
                    nc++;
                }
                if(count[g-'0']-- > 0){
                    nc++;
                }
            }
        }
        
        return retString(nb,nc);
    }
}