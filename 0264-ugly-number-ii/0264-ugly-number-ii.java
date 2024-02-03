class Solution {
    public int findMin(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
    
    public int nthUglyNumber(int n) {
        TreeSet <Long> ts = new TreeSet<>();
        Long count = 1L, n_num = 1L,l_num = 1L;
        ts.add(1L);
        
        while(count <= n){
            l_num = ts.pollFirst();
            //System.out.println("l_num : " + l_num);
            ts.add(l_num * 2);
            ts.add(l_num * 3);
            ts.add(l_num * 5);
            
            count++;            
        }
        
        return l_num.intValue();
    
    }
}