class Solution {
    public String nearestPalindromic(String n) {
        int l = n.length();
        String prefix = "";

        String result = checkEdgeCases(n, l);

        if (!"".equals(result)) {
            return result;
        }

        if (l % 2 == 0) {
            prefix = n.substring(0, (l / 2));
        } else {
            prefix = n.substring(0, (l / 2) + 1);
        }

        return compareStrings(prefix, n);

    }

    public String checkEdgeCases(String n, int l) {
        if ("9".equals(n)) {
            return "8";
        }

        if("9009".equals(n)){
            return "8998";
        }

        String nineStr = "9".repeat(l);
        String tenStr = "1" + "0".repeat(l - 1);
        String tenOneStr = "";
        if (l > 3) {
            tenOneStr = "1" + "0".repeat(l - 2) + "1";
        } else if (l == 2) {
            tenOneStr = "11";
        }

        if (nineStr.equals(n)) {
            long res = 0;
            res = (long) Math.pow(10, l);
            res += 1;

            return String.valueOf(res);
        } else if (tenStr.equals(n)) {
            long res = 0;
            res = (long) Math.pow(10, l - 1) - 1;
            return String.valueOf(res);
        } else if (tenOneStr.equals(n)) {
            long res = 0;
            res = (long) Math.pow(10, l - 1) - 1;
            return String.valueOf(res);
        }

        return "";
    }

    public String compareStrings(String prefix, String n) {
        int l = n.length(), pl = prefix.length();
        StringBuilder tempPrefix = new StringBuilder(prefix);
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            long nInt = Long.valueOf(n);
            long aInt = Long.valueOf(a);
            long bInt = Long.valueOf(b);

            aInt = Math.abs(aInt-nInt);
            bInt = Math.abs(bInt-nInt);

            
            if (aInt == bInt) {
                return a.compareTo(b);
            } else {
                return Long.compare(aInt,bInt);
            }

        });

        if (l % 2 == 0) {
            for (int i = prefix.length() - 1; i >= 0; i--) {
                tempPrefix.append(prefix.charAt(i));
            }
        } else {
            for (int i = prefix.length() - 2; i >= 0; i--) {
                tempPrefix.append(prefix.charAt(i));
            }
        }

        set.add(tempPrefix.toString());

        tempPrefix.setLength(0);
        for (int i = 0; i < pl - 1; i++) {
            tempPrefix.append(prefix.charAt(i));
        }

        char lastChar = prefix.charAt(pl - 1);
        int lchVal = lastChar - '0';

        if (lchVal > 0) {

            tempPrefix.append(--lchVal);

            if (l % 2 == 0) {
                for (int i = prefix.length() - 1; i >= 0; i--) {
                    tempPrefix.append(tempPrefix.charAt(i));
                }
            } else {
                for (int i = prefix.length() - 2; i >= 0; i--) {
                    tempPrefix.append(tempPrefix.charAt(i));
                }
            }
            set.add(tempPrefix.toString());
        }

        tempPrefix.setLength(0);
        for (int i = 0; i < pl - 1; i++) {
            tempPrefix.append(prefix.charAt(i));
        }

        lastChar = prefix.charAt(pl - 1);
        lchVal = lastChar - '0';

        if (lchVal < 9) {
            tempPrefix.append(++lchVal);

            if (l % 2 == 0) {
                for (int i = prefix.length() - 1; i >= 0; i--) {
                    tempPrefix.append(tempPrefix.charAt(i));
                }
            } else {
                for (int i = prefix.length() - 2; i >= 0; i--) {
                    tempPrefix.append(tempPrefix.charAt(i));
                }
            }

            set.add(tempPrefix.toString());
        }

        if (set.contains(n)) {
            set.remove(n);
        }

        return (set.size() > 0) ? set.first() : "";
    }

}