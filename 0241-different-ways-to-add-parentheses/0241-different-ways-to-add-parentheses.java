class Solution {
  List <Integer> [][] dp;
  public List<Integer> diffWaysToCompute(String expression) {
    int n = expression.length();
    dp = new ArrayList[n][n];
    List<Integer> list = solveExpression(0, expression.length() - 1, expression);
    return list;
  }

  public List<Integer> solveExpression(int s, int e, String exp) {
    List<Integer> res = new ArrayList<>();
    boolean hasOper = false;

    if(dp[s][e] != null)
      return dp[s][e]; 

    for (int i = s; i <= e; i++) {
      if (!Character.isDigit(exp.charAt(i))) {
        hasOper = true;
        List<Integer> op1;
        if(dp[s][i-1] == null){
           dp[s][i-1] = solveExpression(s, i - 1, exp);
        }
        op1 = dp[s][i-1];
        
        List<Integer> op2;
         if(dp[i+1][e] == null){
           dp[i+1][e] = solveExpression(i + 1, e, exp);
        }
        op2 = dp[i+1][e];

        String oper = exp.substring(i, i + 1);

        for (int j = 0; j < op1.size(); j++) {
          for (int k = 0; k < op2.size(); k++) {
            if ("+".equals(oper)) {
              res.add(op1.get(j) + op2.get(k));
            } else if ("-".equals(oper)) {
              res.add(op1.get(j) - op2.get(k));
            } else {
              res.add(op1.get(j) * op2.get(k));
            }
          }
        }

      }
    }

    if (!hasOper) {

      int val = Integer.valueOf(exp.substring(s, e + 1));

      res.add(val);
    }

    return res;
  }
}