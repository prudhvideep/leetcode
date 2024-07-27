class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Pair [] pairs = new Pair[nums.length];

        for(int i = 0;i < nums.length;i++){
            pairs[i] = new Pair(nums[i],i);
        }

        int [] res = Arrays.stream(pairs)
                     .sorted((x,y) -> {
                        if(x.v == y.v){
                            return x.i-y.i;
                        }

                        return compare(x.v,y.v,mapping);
                     })
                     .mapToInt(z -> z.v)
                     .toArray();

        return res;
    }

    public int compare(int a,int b,int [] mapping){
        int at = 0, bt = 0, mul = 1, r;
        
        if(a == 0){
            at = mapping[0];
        }else{
            while(a != 0){
                r = a%10;
                at = (mul*mapping[r])+at;
                a=a/10;
                mul = mul*10;
            }
        }
       

        
        mul = 1;
        if(b == 0){
            bt = mapping[0];
        }else{
            while(b != 0){
                r = b%10;
                bt = (mul*mapping[r])+bt;
                b=b/10;
                mul = mul*10;
            }
        }
        

        return at-bt;
    }

    class Pair {
        int v;
        int i;

        public Pair(int val,int id){
            this.v = val;
            this.i = id;
        }
    }

    
}