class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int [] pref = new int[2];
        
        for(int i : students){
            pref[i]++;
        }
        
        for(int sandwich : sandwiches){
            if(pref[sandwich] == 0)
                break;
            
            pref[sandwich]--;
        }
        
        
        return Arrays.stream(pref).sum();
    }
}