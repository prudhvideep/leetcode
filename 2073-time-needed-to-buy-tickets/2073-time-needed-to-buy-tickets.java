class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0,id = 0, n = tickets.length;
        
        while(tickets[k] != 0){
            if(tickets[id] > 0){
                tickets[id]--;
                count++;
            }
            id = (id+1)%n;
        }
        
        return count;
    }
}