class Solution {
    List <List <String>> part = new ArrayList<List<String>>();
    
    public List<List<String>> partition(String s) {
        List <String> list = new ArrayList<>();
        partUtil(list,0,s);
        return part;
    }
    
    void partUtil(List <String> list, int id, String s){
        if(id == s.length()){
            if(isValid(list)){
                part.add(new ArrayList<String> (list));
            }
            return;
        }
        
        for(int i = id;i < s.length();i++){
            String subStr = s.substring(id,i+1);
            list.add(subStr);
            partUtil(list,i+1,s);
            list.remove(list.size()-1);
        }
    }
    
    boolean isValid(List <String> list){
        for(String str : list){
            if(str.length() == 1)
                continue;
            
            if(!isPali(str))
                return false;
        }
        
        return true;
    }
    
    boolean isPali(String s){
        int l = 0, h = s.length()-1;
        
        while(l < h){
            if(s.charAt(l) != s.charAt(h))
                return false;
            
            l++;h--;
        }
        return true;
    }
}