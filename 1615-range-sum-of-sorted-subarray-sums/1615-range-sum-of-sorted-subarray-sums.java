class Solution {
    public final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList <Integer> list = new ArrayList<>(); 

        for(int i = 0;i < nums.length;i++){
            int sum = nums[i];
            list.add(sum);
            for(int j = i+1;j < nums.length;j++){
                sum+= nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);
        
        int rSum = 0;
        for(int i = left-1;i < right;i++){
            rSum = ((rSum % MOD) + (list.get(i) % MOD))%MOD;
        }
       
        return rSum;
    }
}