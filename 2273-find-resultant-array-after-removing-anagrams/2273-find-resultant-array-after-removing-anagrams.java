class Solution {
    public boolean isAnagram(String a, String b){
        int [] ca = new int [26];
        int [] cb = new int [26];
        
        for(int i = 0;i < a.length();i++){
            char c = a.charAt(i);
            ca[c-'a']++;
        }
        
        for(int i = 0;i < b.length();i++){
            char c = b.charAt(i);
            cb[c-'a']++;
        }
        
        for(int i = 0;i < 26;i++){
            if(ca[i] != cb[i])
                return false;
        }
        return true;
    }
    
    public List<String> removeAnagrams(String[] words) {
        int l = 0;
        for(int i = 1;i < words.length;i++){
            if(isAnagram(words[i-1],words[i]))
                continue;
            
            l++;
            words[l] = words[i];
        }
        
        if(l == words.length)
            return Arrays.asList(words);
        
        List <String> ret = new ArrayList<>();
        for(int i = 0;i <= l;i++){
            ret.add(words[i]);
        }
        
        return ret;
    }
}