class Solution {
    public int minimumPushes(String word) {
        int minPush = 0;
        int [] count = new int [26];

        for(int i = 0;i < word.length();i++){
            count[word.charAt(i) - 'a']++;
        } 
        
        Arrays.sort(count);

        int ct = 0, fact = 1;
        for(int i = 25;i >= 0; i--){
            if(count[i] == 0)
                break;

            minPush += count[i]*fact;

            ct++;
            if(ct == 8){
                ct = 0;
                fact++;
            }
        }

        return minPush;
    }
}