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
        Set <Integer> s = new HashSet<>();
        
        for(int i = 0;i < n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                nb++;
                s.add(i);
            }
        }
        for(int i = 0;i < n;i++){
            if(!s.contains(i)){
                char c = secret.charAt(i);
                count[c-'0']++;
            }
        }
        
        for(int i = 0; i < n ;i++){
            if(!s.contains(i)){
                char c = guess.charAt(i);
                if(count[c-'0'] > 0){
                    nc++;
                    count[c-'0']--;
                }
            }
        }
        
        return retString(nb,nc);
    }
}