class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;Long uNum = 0L;
        TreeSet <Long> set = new TreeSet<>((a,b) -> Long.compare(a,b));
        set.add(1L);

        while(count < n){
            uNum = set.pollFirst();
            count++;

            set.add(uNum * 2);
            set.add(uNum * 3);
            set.add(uNum * 5);
        }
        return uNum.intValue();
    }
}