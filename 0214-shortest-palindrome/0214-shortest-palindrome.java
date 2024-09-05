class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        if(n == 1)
            return s;

        if(n == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }
        }

        StringBuilder sStr = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = n / 2; i >= 0; i--) {
            int li = i - 1;
            int ri = i + 1;

            while (li >= 0 && ri < n) {
                if (s.charAt(li) != s.charAt(ri)) {
                    break;
                }
                li--;
                ri++;
            }

            if (li < 0) {
                sb.setLength(0);
                temp.setLength(0);
                for (int k = ri; k < n; k++) {
                    sb.append(s.charAt(k));
                }
                temp.append(sb.reverse());

                temp.append(s);
                
                if (sStr.length() == 0) {
                    sStr.append(temp);
                } else if (sStr.length() > temp.length()) {
                    sStr.setLength(0);
                    sStr.append(temp);
                }
                break;
            }
        }

        for (int i = n / 2; i >= 0; i--) {
            int li = i;
            int ri = i + 1;

            while (li >= 0 && ri < n) {
                if (s.charAt(li) != s.charAt(ri)) {
                    break;
                }
                li--;
                ri++;
            }

            if (li < 0) {
                sb.setLength(0);
                temp.setLength(0);
                for (int k = ri; k < n; k++) {
                    sb.append(s.charAt(k));
                }
                temp.append(sb.reverse());

                temp.append(s);
                
                if (sStr.length() == 0) {
                    sStr.append(temp);
                } else if (sStr.length() > temp.length()) {
                    sStr.setLength(0);
                    sStr.append(temp);
                }
                break;
            }
        }

        return sStr.toString();
    }
}