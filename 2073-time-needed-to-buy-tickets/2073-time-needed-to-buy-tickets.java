class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int e = tickets[k], count = 0;
        
        for(int i = 0;i < tickets.length;i++){
            if(tickets[i] >= e){
                if(i <= k){
                    count = count+e;
                }else{
                    count = count+e-1;
                }
            }else{
                count = count+tickets[i];
            }
        }
        return count;
    }
}