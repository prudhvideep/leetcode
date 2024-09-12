class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int count = num2.length() - i - 1;

            int carry = 0;
            while (count-- > 0) {
                sb.append(0);
            }

            int a = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';

                int pro = (a * b) + carry;
                carry = pro / 10;
                sb.append(pro % 10);
            }
            if (carry != 0) {
                sb.append(carry);
            }

            int k = 0;
            int c = 0, r = 0;
            for (k = 0; k < res.length(); k++) {
                int x = res.charAt(k) - '0';
                int y = sb.charAt(k) - '0';

                int sum = (x + y + c);

                c = sum / 10;
                r = sum % 10;

                char ch = (char) (r + '0');

                sb.setCharAt(k, ch);
            }

            while (c != 0 && k < sb.length()) {
                int x = sb.charAt(k) - '0';

                int sum = (x + c);

                c = sum / 10;
                r = sum % 10;

                char ch = (char) (r + '0');

                sb.setCharAt(k, ch);
                k++;
            }

            if (c != 0) {
                sb.append((char) (c + '0'));
            }

            res = sb;

        }

        res = res.reverse();

        return res.toString();
    }
}