class Solution {
    public char findTheDifference(String s, String t) {
        int [] a = new int[26];
        
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        
        char temp = '*';
        for(int i = 0;i < t.length();i++){
            temp = t.charAt(i);
            
            a[temp-'a']--;
        }
        
        for(int i = 0;i < 26;i++){
            if(a[i] < 0)
                return (char) (i + 'a');
        }
        
        return temp;
    }
    
}