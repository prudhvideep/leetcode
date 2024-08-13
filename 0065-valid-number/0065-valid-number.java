class Solution {
    public boolean hasE(String str){
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == 'E'){
                return true;
            }
        }
        return false;
    }

    public String [] expoSplit(String str){
        if(hasE(str)){
            return str.split("E");
        }

        return str.split("e");
    }

    public boolean hasExponent(String str){
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == 'E' || str.charAt(i) == 'e'){
                return true;
            }
        }
        return false;
    }

    public boolean signedInt(String str, String part){
        if(str.length() == 0) return true;

        

        if(str.length() == 1 && !Character.isDigit(str.charAt(0)) && "p1".equals(part))
            return false;

        
        char fCh = str.charAt(0);
        if(!Character.isDigit(fCh)){
            if(fCh != '-' && fCh != '+')
                return false;
        } 

        for(int i = 1; i < str.length();i++){
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean unsignedInt(String str){
        for(int i = 0;i <  str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isValidExponent(String str,String part){
        if("p0".equals(part)){
            if(str.charAt(0) == 'e'){
                return false;
            }

            if(!Character.isDigit(str.charAt(0)) && (str.charAt(1) == 'E' || str.charAt(1) == 'e')){
                return false;
            }
        }
        if("p1".equals(part)){
            if(str.charAt(0) == 'e' && str.length() == 1){
                return false;
            }
        }

        int lId = str.length()-1;
        if(str.charAt(lId) == 'e' || str.charAt(lId) == 'E')
            return false;

        String [] expSplit = expoSplit(str);
            if(expSplit.length > 2){
                return false;
            }else if(expSplit.length == 2){
                if(signedInt(expSplit[0],"p0") && signedInt(expSplit[1],"p1")){
                    return true;
                }
                return false;
            }else if(expSplit.length == 1){
                if(signedInt(expSplit[0],"p0")){
                    return true;
                }
                
            }
            return false;
    }

    public boolean hasMultipleChars(String s){
        int dotCnt = 0,eCnt = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '.'){
                dotCnt++;
            }
            if(s.charAt(i) == 'E' || s.charAt(i) == 'e'){
                eCnt++;
            }
        }

        if(dotCnt > 1 || eCnt > 1){
            return true;
        }

        return false;
    }

    public boolean hasNoDigits(String s){
        int dCnt = 0;
        for(int i = 0;i < s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                dCnt++;
            }
        }

        if(dCnt == 0)return true;

        return false;
    }

    public boolean isNumber(String s) {
        if(hasMultipleChars(s)){
            return false;
        }
        if(hasNoDigits(s)){
            return false;
        }

        int lId = s.length()-1;

        if(hasExponent(s) && !Character.isDigit(s.charAt(lId)))
            return false;

        String [] parts = s.split("\\.");
        if(parts.length > 2){
            return false;
        }else if(parts.length == 1){
            
            return isValidExponent(parts[0],"p0");
        }else if(parts.length == 2){
            
            if(hasExponent(parts[0]) && hasExponent(parts[1])){
                return false;
            }else if(!hasExponent(parts[0]) && hasExponent(parts[1])){
                if(parts[0].length() == 0 && (parts[1].charAt(0) == 'e' || parts[1].charAt(0) == 'E')){
                    return false;
                }
                if(parts[0].length() == 1 && !Character.isDigit(parts[0].charAt(0))){
                    if(parts[1].charAt(0) == 'e' || parts[1].charAt(0) == 'E'){
                        return false;
                    }
                }
                if(parts[1].charAt(0) == '+' ||  parts[1].charAt(0) == '-'){
                    return false;
                }
                if(signedInt(parts[0],"p0") && isValidExponent(parts[1],"p1")){
                    return true;
                }
            }else if(!hasExponent(parts[0]) && !hasExponent(parts[1])){
                if(signedInt(parts[0],"p0") && unsignedInt(parts[1])){
                    return true;
                }
                return false;
            }else{
                if(hasExponent(parts[0]) && !hasExponent(parts[1])){
                    return false;
                }
            }
        }
        return false;
    }
}