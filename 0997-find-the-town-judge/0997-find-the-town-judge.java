class Solution {
    public int findJudge(int n, int[][] trust) {
        int []deg = new int[n+1];
        Arrays.fill(deg,0);

        for(int i = 0;i < trust.length;i++){
            deg[trust[i][0]]--;
            deg[trust[i][1]]++;
        }

        for(int i = 1;i <= n;i++){
            if(deg[i] == n-1)
                return i;
        }
        return -1;
       
    }
}