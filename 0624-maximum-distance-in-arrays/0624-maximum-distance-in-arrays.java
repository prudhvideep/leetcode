class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int leftMax [] = new int[arrays.size()];
        int rightMax [] = new int[arrays.size()];

        leftMax[0] = Integer.MIN_VALUE;
        for(int i = 1; i < arrays.size();i++){
            List <Integer> prevArr = arrays.get(i-1);
            int prevMax = prevArr.get(prevArr.size()-1);

            leftMax[i] = Math.max(prevMax,leftMax[i-1]); 
        }

        rightMax[arrays.size()-1] = Integer.MIN_VALUE;

        for(int i = arrays.size()-2;i >= 0;i--){
            List <Integer> nextArr = arrays.get(i+1);
            int nextMax = nextArr.get(nextArr.size()-1);

            rightMax[i] = Math.max(nextMax,rightMax[i+1]);
        }
        
        int maxDist = Integer.MIN_VALUE;
        for(int i = 0;i < arrays.size();i++){
            int minEle = arrays.get(i).get(0);

            maxDist = Math.max(maxDist,Math.abs(minEle - Math.max(leftMax[i],rightMax[i])));
        }

        return maxDist;
    }
}