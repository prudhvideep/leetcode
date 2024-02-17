class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    
    public boolean halvesAreAlike(String s) {
        int n = s.length(),count1 = 0, count2 = 0;
        
        for(int i = 0; i < (n/2);i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if(isVowel(c)){
                count1++;
            }
        }
        
        for(int i = n/2;i < n;i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if(isVowel(c)){
                count2++;
            }
        }
        
        if(count1 == count2)
            return true;
        
        return false;
    }
}