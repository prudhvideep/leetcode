class Solution {
    public String simplifyPath(String path) {
        String pathArr[] = path.split("/");
        Stack <String> s = new Stack<>();
        
        for(String str : pathArr){
            if(".".equals(str)){
                continue;
            }else if("..".equals(str)){
                if(!s.isEmpty())s.pop();
                continue;
            }else{
                if(!"".equals(str))s.push(str);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty()){
            sb.insert(0,s.peek());
            sb.insert(0,"/");
            s.pop();
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }
}