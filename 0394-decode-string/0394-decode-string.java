class Solution {
    public String decodeString(String s) {
        Stack <Integer> mSt = new Stack <>();
        Stack <String> sSt = new Stack <>();
        
        StringBuilder fStr = new StringBuilder();
        // "a2[a2[3[b]]c]"
        int bCount = 0;
        StringBuilder digits = new StringBuilder();
        StringBuilder chars = new StringBuilder();

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                digits.append(ch);
            }else if(Character.isLowerCase(ch)){
                chars.append(ch);
                if(bCount == 0){
                   fStr.append(chars.toString());
                   chars.setLength(0);
                }
            }else if(ch == '['){                
                bCount++;
                if(digits.length() > 0){
                    int num = Integer.valueOf(digits.toString());
                    mSt.push(num);
                }
                if(chars.length() > 0){
                    sSt.push(chars.toString());
                }
                chars.setLength(0);
                digits.setLength(0);
            }else if(ch == ']'){
                bCount--;

                if(bCount > 0){
                    int num = mSt.pop();
                    
                    while(sSt.size() > bCount){
                        chars.insert(0,sSt.pop());
                    }
                    String charsStr = chars.toString();
                    charsStr = charsStr.repeat(num);

                    chars = new StringBuilder(charsStr);
                }else{
                    
                    int num = 0;
                    if(mSt.size() > 0){
                        num = mSt.pop();
                    }
                    String charsStr = "";
                    while(!sSt.isEmpty()){
                        charsStr = sSt.pop() + charsStr;
                    }

                    charsStr = charsStr+ (chars.toString());
                    charsStr = charsStr.repeat(num);

                    fStr.append(charsStr);
                    chars.setLength(0);
                }
            }
        }

        return fStr.toString();
    }
}