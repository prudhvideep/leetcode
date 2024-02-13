class Solution {
    public boolean isPali(String word){
        int l = 0, h = word.length()-1;
        while(l <= h){
            if(word.charAt(l) != word.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    
    public String firstPalindrome(String[] words) {
        for(int i = 0;i < words.length;i++){
            if(isPali(words[i])){
                return words[i];
            }
        }
        return "";
    }
}