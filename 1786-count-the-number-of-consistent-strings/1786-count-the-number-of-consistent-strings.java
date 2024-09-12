class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] map = new int[26];

        for (int i = 0; i < allowed.length(); i++) {
            int id = allowed.charAt(i) - 'a';
            map[id]++;
        }

        int count = 0;

        for (String str : words) {
            boolean consistent = true;
            for(int i = 0;i < str.length();i++){
                int id = str.charAt(i)-'a';

                if(map[id]  == 0){
                    consistent = false;
                    break;
                }
            }

            if(consistent){
                count++;
            }
        }

        return count;

    }
}