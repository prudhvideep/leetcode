class Solution {
    public int minimumPushes(String word) {
        int minPush = 0;
        int [] count = new int [26];

        for(int i = 0;i < word.length();i++){
            count[word.charAt(i) - 'a']++;
        } 
        
        List <Integer> list = Arrays.stream(count).boxed().sorted((a,b) -> (b-a)).toList();

        int ct = 0, fact = 1;
        for(int c : list){
            if(c == 0)
                continue;

            minPush += c*fact;

            ct++;
            if(ct == 8){
                ct = 0;
                fact++;
            }
        }

        return minPush;
    }
}