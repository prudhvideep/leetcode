class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int [] ret = new int[n];

        int mRollSum = 0;
        for(int i : rolls){
            mRollSum += i;
        }

        int reqSum = ((m+n)*mean) - mRollSum;
        if(reqSum <= 0)
            return new int[0];

        if(reqSum < n)
            return new int[0];

        int d = reqSum/n;
        int r = reqSum%n;

        if(d > 6){
            return new int[0];
        }

        if(d == 6 && r!= 0){
            return new int[0];
        }

        for(int i = 0;i < n;i++){
            ret[i] = d;
        }


        int id = 0;
        while( (id < n && r > 0) && r != 0){
            int diff = 6 - ret[id];

            if(diff > 0 && diff <= r){
                ret[id] += diff;
                r-=diff;
            }else if(diff > r){
                ret[id]+=r;
                r = 0;
            }
            id++;
        }

        return ret;
    }
}