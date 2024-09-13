class Solution {
  List<List<Integer>> list = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    Set<Integer> seen = new HashSet<>();
    List<Integer> curList = new ArrayList<>();

    helper(1, k, n, curList);
    return list;
  }

  public void helper(int id, int k, int n, List<Integer> curList) {
    if (n < 0 || k < 0)
      return;

    if (n == 0 && k == 0) {
      list.add(new ArrayList(curList));
    }

    for (int i = id; i <= 9; i++) {
      curList.add(i);
      helper(i + 1, k - 1, n - i, curList);
      curList.remove(curList.size() - 1);
    }
  }

}