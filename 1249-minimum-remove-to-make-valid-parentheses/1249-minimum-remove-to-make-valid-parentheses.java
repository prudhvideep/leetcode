class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        Set <Integer> set = new HashSet<>();
        
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(')
            {
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
                
                if(count < 0){
                    set.add(i);
                    count = 0;
                }
            }
        }
        
        count = 0;
        
        for(int i = s.length()-1;i >=0;i--){
            if(s.charAt(i) == ')')
            {
                count++;
            }else if(s.charAt(i) == '('){
                count--;
                
                if(count < 0){
                    set.add(i);
                    count = 0;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i < s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
        
    }
}