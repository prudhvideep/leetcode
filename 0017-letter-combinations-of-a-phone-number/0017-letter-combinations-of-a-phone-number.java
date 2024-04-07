class Solution {
    public List<String> list = new ArrayList<>();
    
    public List<String> letterCombinations(String digits){
        if(digits.length() == 0)
            return list;
        
        HashMap <Character,String> hm = new HashMap<>();
        
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        
        String [] strings = new String[digits.length()];
        
        for(int i = 0;i < digits.length();i++){
            strings[i] = hm.get(digits.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        buildList(strings,0,sb);
        
        return list;
    }
    
    public void buildList(String [] strings,int strId, StringBuilder sb){      
        if(sb.length() == strings.length){
            list.add(sb.toString());
            return;
        }
        
        for(int i = 0;i < strings[strId].length();i++){
            sb.append(strings[strId].charAt(i));
            buildList(strings,strId+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}