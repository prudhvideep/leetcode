class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1, s = 0, c = 0,x,y;
        StringBuffer sb = new StringBuffer();
        
        while(i >= 0 && j >= 0){
            x = (a.charAt(i) == '0') ? 0 : 1;
            y = (b.charAt(j) == '0') ? 0 : 1;
                        
            s = (x+y+c)%2;
            c = (x+y+c)/2;
            
            sb.insert(0,(s == 1)?'1':'0');
            i--;
            j--;
        }
        
        while(i >= 0){
            x = (a.charAt(i) == '0') ? 0 : 1;
            s = (x+c)%2;
            c = (x+c)/2;
            sb.insert(0,(s == 1)?'1':'0');
            i--;
        }
        while(j >= 0){
            y = (b.charAt(j) == '0') ? 0 : 1;
            s = (y+c)%2;
            c = (y+c)/2;
            sb.insert(0,(s == 1)?'1':'0');
            j--;
        }
        if(c != 0)
            sb.insert(0,(c == 1)?'1':'0');
        
        return sb.toString();
    }
}