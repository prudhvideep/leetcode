class Solution {
  public List<Integer> goodDaysToRobBank(int[] security, int time) {
    int[] ni = new int[security.length];
    int[] nd = new int[security.length];

    for (int i = 0; i < security.length; i++) {
       if(i == 0) {
        ni[i] = 1;
        continue;
       }

       if(security[i-1] >= security[i]){
        ni[i] = ni[i-1]+1;
       }else{
        ni[i] = 1;
       }
    }

    for (int i = security.length-1; i >=0 ; i--) {
      if(i == security.length-1){
        nd[i] = 1;
        continue;
      }

      if(security[i+1] >= security[i]){
        nd[i] = nd[i+1] + 1;
      }else{
        nd[i] = 1;
      }
    }
    
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < security.length;i++) {
      if((ni[i] >= time+1) && (nd[i] >= time+1)) list.add(i); 
    }

    return list;
  }
}