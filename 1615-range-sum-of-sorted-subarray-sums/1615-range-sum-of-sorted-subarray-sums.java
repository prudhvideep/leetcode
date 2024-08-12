class Solution {
    public final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)-> (a-b));

        for(int i = 0;i < nums.length;i++){
            int sum = nums[i];
            pq.add(sum);
            for(int j = i+1;j < nums.length;j++){
                sum+= nums[j];
                pq.add(sum);
            }
        }


        int pe = left-1;

        while(pe-- > 0){
            pq.poll();
        }
        
        int rSum = 0;

        while(left <= right){
            rSum = ((rSum % MOD) + (pq.poll() % MOD)) % MOD;
            left++;
        }
        return rSum;
    }
}