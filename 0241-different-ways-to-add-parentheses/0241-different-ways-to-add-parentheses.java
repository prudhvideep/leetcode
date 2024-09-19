class Solution {

  public List<Integer> diffWaysToCompute(String expression) {

    List<Integer> list = solveExpression(0, expression.length() - 1, expression);
    return list;
  }

  public List<Integer> solveExpression(int s, int e, String exp) {
    List<Integer> res = new ArrayList<>();
    boolean hasOper = false;

    for (int i = s; i <= e; i++) {
      if (!Character.isDigit(exp.charAt(i))) {
        hasOper = true;
        List<Integer> op1 = solveExpression(s, i - 1, exp);
        List<Integer> op2 = solveExpression(i + 1, e, exp);

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