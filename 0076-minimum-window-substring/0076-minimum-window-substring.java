class Solution {
    public boolean compare(int [] temp,int [] count){
        for(int i = 0;i < 256;i++){
            if(temp[i] < count[i])
                return false;
        }
        return true;
    }

    public boolean inCount(char c,int [] count){      
     if(count[c] > 0)
        return true;

      return false;
    }
    
    public String minWindow(String s, String t) {
        int [] count = new int [256];
        int sl = s.length(), tl = t.length(), minW = Integer.MAX_VALUE;
        
        if(tl > sl)
            return "";
    
        for(int i = 0;i < tl;i++){
           char c = t.charAt(i);
           count[c]++;   
        }
        
       
        int i = 0, l = 0, h = 0;
        int [] temp = new int[256];
        
        String minStr =  "";
        
        while(h < sl){
           char t2 = s.charAt(h);
           //System.out.println("l : " + l);
           //System.out.println("h : " + h);
            
           if(inCount(t2, count)){
                temp[t2]++;
           }
            
           while(compare(temp,count) && (l <= h)){
               if((h-l+1) < minW){
                   minW = (h-l+1);
                   minStr = s.substring(l,h+1);
               }
               
               if(count[s.charAt(l)] > 0)temp[s.charAt(l)]--;
               
               l++;
           }
            
           h++;
        }
        
        return minStr;
        
    }
}