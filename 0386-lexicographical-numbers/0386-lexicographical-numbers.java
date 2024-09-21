class Solution {
  List<Integer> list;

  public List<Integer> lexicalOrder(int n) {
    list = new ArrayList<Integer>();
    for(int  i = 1;i <= 9;i++){
      helper(i,n);
    }
    return list;
  }

  public void helper(int cn,int n) {
    if(cn > n) return;

    list.add(cn);

    for(int i = 0;i <= 9;i++){
      helper(cn*10+i,n);
    } 
  }
}