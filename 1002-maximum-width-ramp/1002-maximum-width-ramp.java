class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Pair> list = new ArrayList<>();
        int mw = 0;
        for(int i = nums.length-1;i >= 0; i--){
          if(list.size() == 0){
            list.add(new Pair(nums[i],i));
            continue;
          }

          if(nums[i] > list.get(list.size()-1).el){
            list.add(new Pair(nums[i],i));
          }else if(nums[i] == list.get(list.size()-1).el){
            mw = Math.max(mw,list.get(list.size()-1).id - i);
          }else if(nums[i] < list.get(list.size()-1).el){
            for(Pair p : list){
              if(nums[i] <= p.el){
                 mw = Math.max(mw,p.id - i);
                 break;
              }
            }
          }
        }

        return mw;
    }

    class Pair{
      int el;
      int id;
      Pair(int el, int id){
        this.el = el;
        this.id = id;
      }
    }
}