class Solution {
    public int maxProfit(int[] prices) {
        int [] temp = new int[prices.length];
        
        for(int i = prices.length-1;i>=0;i--){
            if(i == prices.length-1){
                temp[i] = prices[i];
                continue;
            }
            if(prices[i] > temp[i+1])
                temp[i] = prices[i];
            else
                temp[i] = temp[i+1];
        }
        
        int maxP = 0;
        for(int i = 0;i < prices.length;i++){
            maxP = Math.max(maxP,temp[i]-prices[i]);
        }
        return maxP;
    }
}