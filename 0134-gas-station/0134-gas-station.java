class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, totSurplus = 0, id = 0, n = gas.length;
        
        for(int i = 0;i < n;i++){
            totSurplus += gas[i] - cost[i];
            surplus+= gas[i] - cost[i];
            if(surplus < 0){
                id = i+1;
                surplus = 0;
            }
        }
        
        return (totSurplus < 0)? -1 : id;
    }
}