class Solution {
    public boolean parseBoolExpr(String exp) {
        Set <Character> op = new HashSet<>();

        op.add('&');
        op.add('|');
        op.add('!');

        Set <Character> bl = new HashSet<>();

        bl.add('f');
        bl.add('t');

        Stack <Pair> opSt = new Stack<>();
        Stack <Pair> expSt = new Stack<>();

        int count = 0;
        for(int i = 0; i < exp.length();i++){
          char ch = exp.charAt(i);
          if(op.contains(ch)){
            count++;
            opSt.push(new Pair(ch,count));
            continue;
          }else if(bl.contains(exp.charAt(i))){
            expSt.push(new Pair(ch,count));
            continue;
          }else if(ch == ')'){
            char oper = ' ';
            // System.out.println(opSt);
            // System.out.println(expSt);
            if(!opSt.isEmpty()){
              oper = opSt.pop().c;
            }

            List<Character> elems = new ArrayList<>();

            while(!expSt.isEmpty() && expSt.peek().i == count){
              elems.add(expSt.peek().c);
              expSt.pop();
            }

            if(oper != ' '){
              char res = getExpResult(elems,oper);
              count--;
              expSt.push(new Pair(res,count));
            }
          }
        }

        System.out.println(expSt);

        return expSt.peek().c == 't' ? true : false;
    }

    char getExpResult(List<Character> elems,char op){
      System.out.println(elems + " " + op);
      char retChar = ' ';
      if(op == '&'){
        boolean allTrue = true; 
        for(char c : elems){
          if(c == 'f'){
            retChar = 'f';
            allTrue = false;
            break;
          }
        }

        if(allTrue){
          retChar = 't';
        }
      }else if(op == '|'){
        boolean allFalse = true;
        for(char c : elems){
          if(c == 't'){
            retChar = 't';
            allFalse = false;
            break;
          }
        }

        if(allFalse){
          retChar = 'f';
        }
      }else if(op == '!'){
        if(elems.size() == 1){
          retChar = elems.get(0) == 't' ? 'f' : 't';
        } 
      }
      System.out.println(retChar);
      return retChar;
    }

    class Pair{
      char c;
      int i;
      Pair(char c,int i){
        this.c = c;
        this.i = i;
      }

      @Override
      public String toString(){
        return this.c + " " + this.i;
      }
    }
}

