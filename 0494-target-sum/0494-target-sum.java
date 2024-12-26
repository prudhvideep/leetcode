class Solution {
  int expCount = 0;

  public int findTargetSumWays(int[] nums, int target) {
    int[] buf = new int[nums.length];
    helper(0, buf, nums, target);

    return expCount;

  }

  public void helper(int id, int[] buf, int[] nums, int target) {
    if (id == buf.length) {
      int sum = 0;
      for (int i : buf) {
        sum += i;
      }

      if (sum == target) {
        expCount++;
      }

      return;
    }

    buf[id] = nums[id];
    helper(id + 1, buf, nums, target);

    buf[id] = -1 * nums[id];
    helper(id + 1, buf, nums, target);

  }
}