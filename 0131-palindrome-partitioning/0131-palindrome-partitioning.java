class Solution {
    
    public List<List<String>> partition(String s) {
        List <List <String>> part = new ArrayList<>();
        partUtil(new ArrayList<>(),0,s,part);
        return part;
    }
    
    private void partUtil(List <String> list, int id, String s, List <List <String>> part){
        if(id == s.length()){
            part.add(new ArrayList<String> (list));
            return;
        }
        
        for(int i = id;i < s.length();i++){
            if(isPali(s,id,i)){
                list.add(s.substring(id,i+1));
                partUtil(list,i+1,s,part);
                list.remove(list.size()-1);   
            }
        }
    }
    
    private boolean isPali(String s,int l,int h){        
        while(l < h){
            if(s.charAt(l) != s.charAt(h))
                return false;
            
            l++;h--;
        }
        return true;
    }
}