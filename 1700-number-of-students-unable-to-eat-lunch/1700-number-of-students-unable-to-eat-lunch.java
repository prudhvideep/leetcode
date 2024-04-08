class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int c0 = 0, c1 = 0, sl = students.length, swl = sandwiches.length;
        
        for(int i = 0;i < students.length;i++){
            if(students[i] == 1)
                c1++;
            
            if(students[i] == 0)
                c0++;
        }
                
        int sId = 0, wId = 0, count = 0;
        
        while(true){
            count = 0;
            
            while(count <= sl && students[sId] != sandwiches[wId]){
                sId = (sId+1)%sl;
                count++;  
            }
            
            if(count >= sl)
                break;
            
            if(students[sId] == sandwiches[wId]){
                if(students[sId] == 1){
                    c1--;
                }else{
                    c0--;
                }
                
                students[sId] = -1;
                sId = (sId+1)%sl;
                wId = (wId+1)%swl;
            }            
        }
        
        return (c1+c0);
    }
}