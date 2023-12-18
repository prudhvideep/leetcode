class Solution {
    public String validIPAddress(String queryIP) {
        String [] str = {"IPv4","IPv6","Neither"};
        boolean hasDigit = false, hasValidChar = false,hasColon = false, hasPeriod = false;
        int ipLen = queryIP.length();
        
        if(ipLen > 40)
            return str[2];
        
        for(int i = 0;i < queryIP.length();i++){
            char c = queryIP.charAt(i);
            
            if(i == 0 || i == ipLen-1){
                if(!Character.isDigit(c) && !((c >= 'a' &&  c <= 'f') || (c >= 'A' && c <= 'F'))){
                    return str[2];
                }
                    
            }
            if(Character.isDigit(c)){
                hasDigit = true;
                continue;
            }
            if(c == ':'){
                hasColon = true;
                continue;
            }
            if(c == '.'){
                hasPeriod = true;
                continue;
            }
            if((c >= 'a' &&  c <= 'f') || (c >= 'A' && c <= 'F')){
                hasValidChar = true;
                continue;
            }
            return str[2];
        }
        
        if(hasDigit == true && hasValidChar == false && hasPeriod == true && hasColon == false){
            
            int temp;
            String [] aStr = queryIP.split("\\.");
            if(aStr.length != 4) 
                return str[2];
            
            for(String lStr : aStr){
                if(lStr.length() == 0)
                    return str[2];
                
                temp = Integer.parseInt(lStr);
                
                if(lStr.length() > 1 && lStr.charAt(0) =='0')
                    return str[2];
                if(!((0 <= temp) && (temp <= 255)))
                    return str[2];
            }
            return str[0];
        }
        
        if(hasValidChar == true && hasPeriod == false && hasColon == true){
            int temp;
            String [] aStr = queryIP.split("\\:");
            if(aStr.length != 8)
                return str[2];
            
            for(String lStr : aStr){
                if(!(lStr.length() >= 1 && lStr.length() <= 4)){
                     return str[2];   
                }
            }
            
            return str[1];
        }
        return str[2];
    }
}