class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int i = 0,count = 0;

        while(i < n){
            
            int j = i+1;
            count = 1;
            while(j < n && (chars[i] == chars[j])){
                count++;
                j++;
            }
            
            sb.append(chars[i]);
            if(count > 1){
                String countStr = Integer.toString(count);
                for(int k = 0;k < countStr.length();k++){
                    sb.append(countStr.charAt(k));
                }
            }

            i = j;
        }

        for(int k = 0;k < sb.length();k++){
            chars[k] = sb.charAt(k);
        }

        return sb.length();
    }
}