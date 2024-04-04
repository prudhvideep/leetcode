class Solution {
    List <List <String>> part = new ArrayList<List<String>>();
    
    public List<List<String>> partition(String s) {
        List <String> list = new ArrayList<>();
        partUtil(list,0,s);
        return part;
    }
    
    void partUtil(List <String> list, int id, String s){
        if(id == s.length()){
            part.add(new ArrayList<String> (list));
            return;
        }
        
        for(int i = id;i < s.length();i++){
            if(isPali(s,id,i)){
                list.add(s.substring(id,i+1));
                partUtil(list,i+1,s);
                list.remove(list.size()-1);   
            }
        }
    }
    
    boolean isPali(String s,int l,int h){        
        while(l < h){
            if(s.charAt(l) != s.charAt(h))
                return false;
            
            l++;h--;
        }
        return true;
    }
}