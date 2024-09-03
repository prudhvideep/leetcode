class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            int v = (int) (c - 'a') + 1 ;
            sb.append(v);
        }

        while(k-- > 0){
            int sum = 0;
            for(int i = 0; i < sb.length();i++){
                sum += sb.charAt(i)-'0';
            }

            sb.setLength(0);
            sb.append(sum);
        }

        String ret = sb.toString();

        return Integer.valueOf(ret);
    }
}