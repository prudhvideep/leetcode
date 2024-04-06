class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        char [] arr = s.toCharArray();
        
        
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == '(')
            {
                count++;
            }else if(arr[i] == ')'){
                count--;
                if(count < 0){
                    arr[i] = '*';
                    count = 0;
                }
            }
        }
        
        count = 0;
        
        for(int i = arr.length-1;i >=0;i--){
            if(arr[i] == ')')
            {
                count++;
            }else if(arr[i] == '('){
                count--;
                if(count < 0){
                    arr[i] = '*';
                    count = 0;
                }
            }
        }
        
        int len = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != '*'){
                arr[len++] = arr[i];
            }
        }
        
        return new String(arr).substring(0,len);
        
    }
}