class Solution {
  public long dividePlayers(int[] skill) {
    int sum = 0;
    int n = skill.length;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int s : skill) {
      sum += s;
      hm.put(s, hm.getOrDefault(s, 0) + 1);
    }

    if (hm.keySet().size() == 1) {

      return (long) ((n / 2) * Math.pow(skill[0], 2));
    }

    if (sum % (n / 2) != 0) {
      return -1L;
    }

    int reqSum = (sum / (n / 2));
    long totSkill = 0;

    for (int s : skill) {
      if (hm.containsKey(s)) {
        int count = hm.get(s);

        if (hm.containsKey((reqSum - s))) {
          if (count == 1) {
            hm.remove((s));
          } else {
            hm.put((s), count - 1);
          }
          int reqCount = hm.get((reqSum - s));

          if (reqCount == 1) {
            hm.remove((reqSum - s));
          } else {
            hm.put((reqSum - s), reqCount - 1);
          }

          totSkill += (s * (reqSum - s));
        } else {
          return -1L;
        }
      }
    }

    return totSkill;
  }
}