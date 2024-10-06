class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String [] s1 = sentence1.split(" ");
        String [] s2 = sentence2.split(" ");

        int l1 = 0, l2 = 0;
        int h1 = s1.length-1, h2 = s2.length-1;

        while(l1 < s1.length && l2 < s2.length && s1[l1].equals(s2[l2])){
          l1++;
          l2++;
        }

        while(h1 >= 0 && h2 >= 0 && s1[h1].equals(s2[h2])){
          h1--;
          h2--;
        }

        if(h1-l1+1 == s1.length){
          return false;
        }

        if(h2-l2+1 == s2.length){
          return false;
        }

        if(Math.min((h2-l2+1),(h1-l1+1)) > 0){
          return false;
        }

        return true;
    }
}