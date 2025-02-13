class Solution {

  public int maximumSum(int[] nums) {
    HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

    for (int num : nums) {
      int sum = getSum(num);

      if (!mp.containsKey(sum)) {
        mp.put(sum, new PriorityQueue<Integer>((a, b) -> (b - a)));
      }

      mp.get(sum).add(num);
    }

    int maxSum = -1;
    for (int key : mp.keySet()) {
       if(mp.get(key).size() > 1){
          int tsum = mp.get(key).poll() + mp.get(key).poll();
          maxSum = Math.max(maxSum,tsum);
       }
    }

    return maxSum;

  }

  public int getSum(int num) {
    int sum = 0;

    while (num != 0) {
      int r = num % 10;
      sum += r;
      num = num / 10;
    }

    return sum;
  }
}