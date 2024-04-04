class Solution {
    List<String> mainList = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        List <String> list = new ArrayList<>();
        helper(s,0,list,0);
        return mainList;
    }
    
    public void helper(String s, int id, List <String> list,int dots){
    
    if(dots == 3){
      String rem = s.substring(id, s.length());
      list.add(rem);
      isValid(list);
      list.remove(list.size()-1);
      return;      
    }

    for(int i = id; (i < id+3 && i < s.length());i++){
      String sub = s.substring(id,i+1);
      list.add(sub);
      list.add(".");
      helper(s, i+1, list, dots+1);
      list.remove(list.size()-1);
      list.remove(list.size()-1);
    }
  }

  public void isValid(List<String> list){
      //System.out.println(list);
      StringBuffer sb = new StringBuffer();

      int count = 0;
      for(int i = 0;i < list.size();i++){
        if(list.get(i) == ".")
         continue;
        
        String temp = list.get(i);
        if(temp.length() > 1  && temp.charAt(0) == '0')
          return;
        
        if(temp.length() == 0 || temp.length() > 4)
          return;

        int a = Integer.parseInt(temp);

        if(!(a >= 0 && a <= 255))
          return;
        
        count++;
        sb.append(temp);
        if(count <= 3)sb.append(".");
      }
      mainList.add(sb.toString());
  }
}