class Solution {
    public String compressedString(String word) {
        int l = 0, h = 1,c = 1;
        StringBuilder sb = new StringBuilder();

        while(h < word.length()){
          if(word.charAt(l) == word.charAt(h) && (c < 9)){
            c++;
          }else{
            sb.append(c);
            sb.append(word.charAt(l));

            c = 1;
            l = h;
          }

          h++;
        }

        sb.append(c);
        sb.append(word.charAt(l));

        return sb.toString();
    }
}