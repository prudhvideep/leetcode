class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;

        for(int i : chalk){
            sum += i;
        }
        
        if(k >= sum){
            k = k % ((int) sum);
        }

        int id;
        for(id = 0;id < chalk.length;id++){
            if(chalk[id] <= k ){
                k -= chalk[id];
            }else{
                break;
            }
        }

        return id;
    }
}