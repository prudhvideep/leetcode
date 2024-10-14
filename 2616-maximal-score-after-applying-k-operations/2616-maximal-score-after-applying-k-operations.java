class Solution {
  public long maxKelements(int[] nums, int k) {
    long sum = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      return b - a;
    });

    for (int i : nums) {
      pq.add(i);
    }

    int ct = k;

    while (k-- > 0) {
      sum += pq.peek();

      int top = pq.poll();
      top = (int) Math.ceil((double) top / (double) 3);

      pq.add(top);
    }

    return sum;
  }
}