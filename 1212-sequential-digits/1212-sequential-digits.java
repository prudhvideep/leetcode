class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        
      
        for(int i = 1; i <=9;i++) {
          int num = i;
          int nextNum = i+1;

          while(nextNum <= 9){
            num = num*10 + nextNum;

            if(num >= low && num <= high){
              res.add(num);
            }

            nextNum++;
          }
        }

        Collections.sort(res);

        return res;
    }
}