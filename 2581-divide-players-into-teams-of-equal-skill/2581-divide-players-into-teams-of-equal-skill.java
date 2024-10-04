class Solution {
  public long dividePlayers(int[] skill) {
    int sum = 0;
    int n = skill.length;
    int [] hm = new int[1001];

    for (int s : skill) {
      sum += s;
      hm[s]++;

      if(hm[s] == n){
        return (long) ((n/2) * (Math.pow(s,2)));
      }
    }
    
    if (sum % (n / 2) != 0) {
      return -1L;
    }

    int reqSum = (sum / (n / 2));
    long totSkill = 0;

    for (int s : skill) {
      if (hm[s] > 0) {
        int count = hm[s];

        if (hm[reqSum - s] > 0) {
          hm[s]--;
          hm[reqSum - s]--;
          totSkill += (s * (reqSum - s));
        } else {
          return -1L;
        }
      }
    }

    return totSkill;
  }
}