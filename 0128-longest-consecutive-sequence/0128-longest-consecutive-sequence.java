class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0,count = 0, cEle;
        Set <Integer> nVisited  = new HashSet<>();

        for(int i : nums){
            nVisited.add(i);
        }

        for(int i : nums){
            if(!nVisited.contains(i-1)){
                nVisited.remove(i);
                count = 1;
                cEle = i;
                while(nVisited.contains(cEle+1)){
                    nVisited.remove(cEle);
                    count++;
                    cEle++;
                }
                maxCount = Math.max(count,maxCount);
            }   
        }

        return maxCount;
    }
}