class Solution {
    public int minimumPushes(String word) {
        int minPush = 0;
        int [] count = new int [26];
        Set <Character> set = new HashSet<>();

        for(int i = 0;i < word.length();i++){
            count[word.charAt(i) - 'a']++;
            set.add(word.charAt(i));
        } 
        
        List <Character> list = set.stream().sorted((a,b) -> {
            return count[b-'a'] - count[a-'a'];
        }).toList();

        int ct = 0, fact = 1;
        for(Character c : list){
            minPush += count[c-'a']*fact;

            ct++;
            if(ct == 8){
                ct = 0;
                fact++;
            }
        }

        return minPush;
    }
}