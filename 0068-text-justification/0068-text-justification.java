class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        boolean lastLine = false;
        List<String> ret = new ArrayList<>();

        ArrayList<String> al = new ArrayList<>();
        int charCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (al.size() == 0) {
                al.add(words[i]);
                charCount += words[i].length();
            } else {
                if (charCount + al.size() + words[i].length() <= maxWidth) {
                    al.add(words[i]);
                    charCount += words[i].length();
                } else {
                    StringBuilder sb = new StringBuilder();
                    int slots = Math.max(al.size() - 1, 1);
                    int spaceCount = (maxWidth - charCount);
                    int r = (maxWidth - charCount) % slots;
                    int n = (maxWidth - charCount) / slots;

                    for (int j = 0; j < al.size() - 1; j++) {
                        sb.append(al.get(j));
                        if (r > 0) {
                            sb.append(" ".repeat(n + 1));
                            spaceCount -= n+1;
                            r--;
                        } else {
                            sb.append(" ".repeat(n));
                            spaceCount -= n;
                        }
                    }

                    sb.append(al.get(al.size()-1));
                    if(spaceCount > 0){
                        sb.append(" ".repeat(spaceCount));
                    }

                    ret.add(sb.toString());

                    al.clear();
                    charCount = 0;
                    al.add(words[i]);
                    charCount += words[i].length();
  
                }
            }
        }

        int slots = Math.max(al.size() - 1, 1);
        int spaceCount = (maxWidth - charCount);
        int n = (spaceCount > 0) ? 1 : 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < al.size() - 1; j++) {
            sb.append(al.get(j));
            sb.append(" ".repeat(n));
            spaceCount -= n;
        }
                 

        sb.append(al.get(al.size()-1));
        if(spaceCount > 0){
            sb.append(" ".repeat(spaceCount));
        }

        ret.add(sb.toString());


        return ret;
    }
}