class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> r = new ArrayList<>();
        int lPar = 0, rPar = 0;
        
        parUtil("",n,0,0,r);
        
        return r;
    }
    
    public void parUtil(String s, int n, int lPar, int rPar, List <String> r){
        if(lPar == n && rPar == n){
            r.add(s);
            return;
        }
        if(lPar < n){
            parUtil(s+"(",n,lPar+1,rPar,r);
        } 
        if(rPar < lPar){
            parUtil(s+")",n,lPar,rPar+1,r);
        }
    }
}