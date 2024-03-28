class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = digits.length, s = 0, c = 0;
        
        for(int i = n-1;i>=0;i--){
            int num = digits[i];
            
            if(i == n-1){
                s = num+1;
                c = s/10;
                s = s%10;
                
                list.add(0,s);
                
                continue;
            }
            
            s = num+c;
            c=s/10;
            s=s%10;
            list.add(0,s);
        }
        
        if(c != 0){
            list.add(0,c);
        }
        
        int [] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
        
    }
}