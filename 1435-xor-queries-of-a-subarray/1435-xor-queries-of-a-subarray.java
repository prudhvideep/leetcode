class Solution {
    class RangeTree{
      int s;
      int e;
      int x;
      RangeTree left;
      RangeTree right;

      public RangeTree(int start,int end){
        this.s = start;
        this.e = end;

        this.left = null;
        this.right = null;
      }
    }

    public RangeTree buildTree(int start,int end,int [] arr){
        if(start == end){
          RangeTree leaf = new RangeTree(start,end);
          leaf.x = arr[start];
          return leaf;
        }

        int m = (start+end)/2;

        RangeTree root = new RangeTree(start,end);

        root.left = buildTree(start,m,arr);

        root.right = buildTree(m+1,end,arr);

        root.x = (root.left.x ^ root.right.x);

        return root;
    }

    public int findXor(RangeTree root,int start,int end){
       if(root.s == start && root.e == end){
          return root.x;
        }

        int m = (root.s + root.e)/2;

        if(start > m){
          return findXor(root.right,start,end);
        }

        if(end <= m){
          return findXor(root.left,start,end);
        }

        return findXor(root.left,start,m) ^ findXor(root.right,m+1,end);
    }



    public int[] xorQueries(int[] arr, int[][] queries) {
      RangeTree root = buildTree(0,arr.length-1,arr);

      int ret [] = new int[queries.length];

      for(int i = 0;i < queries.length;i++){
        int s = queries[i][0];
        int e = queries[i][1];

        ret[i] = findXor(root,s,e); 
      }

      return ret;
    }
}