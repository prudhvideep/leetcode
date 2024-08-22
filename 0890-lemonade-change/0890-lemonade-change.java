class Solution {
    public int mapping(int bill){
        if(bill == 5){
            return 0;
        }else if(bill == 10){
            return 1;
        }else{
            return 2;
        }
    }

    public boolean lemonadeChange(int[] bills) {
        int [] count = new int [3];
        
        for(int bill : bills){
            count[mapping(bill)]++;
            if(bill == 5)
                continue;
            
            if(bill == 10){
                if(count[mapping(5)]-- > 0){
                    continue;
                }else{
                    return false;
                }
            }

            if(bill == 20){
                 if(count[mapping(5)] >= 1 && count[mapping(10)] >= 1){
                    count[mapping(5)]--;
                    count[mapping(10)]--;
                    continue;
                }else if(count[mapping(5)] >= 3){
                    count[mapping(5)] -= 3;
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}