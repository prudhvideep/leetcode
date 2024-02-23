class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        
        int m = v1.length, n = v2.length;
        
        for(int i = 0; i < Math.min(m,n);i++){
            int a_v1 = Integer.valueOf(v1[i]);
            int b_v2 = Integer.valueOf(v2[i]);
            
            if(a_v1 < b_v2)return -1;
            if(a_v1 > b_v2)return 1;
        }
        
        for(int i = Math.min(m,n);i < Math.max(m,n);i++){
            if(v1.length == Math.max(m,n)){
                int a_v1 = Integer.valueOf(v1[i]);
                if(a_v1 > 0) return 1;
            }else if(v2.length == Math.max(m,n)){
                int b_v2 = Integer.valueOf(v2[i]);
                if(b_v2 > 0) return -1;
            }
        }
        return 0;
    }
}