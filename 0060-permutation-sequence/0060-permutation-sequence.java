class Solution {
    
    public int count = 0;
    public int kseq = 0;
    public int k = 0;
    
    public String perm = "";
    
    public String getPermutation(int n, int k) {
        int [] arr = new int[n+1];
        StringBuffer sb = new StringBuffer();
        this.k = k;
        
        for(int i = 1;i <= n;i++){
            arr[i] = 1;
        }
        
        genPerm(arr,sb,n);
        
        return perm;
        
    }
    
    public void genPerm(int [] arr, StringBuffer sb, int n){
        if(sb.length() == n){
            kseq++;
            if(kseq == k){
                perm = sb.toString();
            }
            return;
        }
        
        
        for(int i = 1;i <=n;i++){
            if(arr[i] == 1){
                char c = (char) (i + '0');
                sb.append(c);
                arr[i] = 0;
                genPerm(arr,sb,n);
                arr[i] = 1;
                sb.deleteCharAt(sb.length()-1);
            } 
        }
    }
}