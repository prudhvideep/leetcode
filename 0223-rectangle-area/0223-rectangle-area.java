class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int al = Math.abs(ax1-ax2);
        int ab = Math.abs(ay1-ay2);

        int aA = al*ab;

        int bl = Math.abs(bx1-bx2);
        int bb = Math.abs(by1-by2);

        int bA = bl * bb;

        if(bx1 > ax2 || bx2 < ax1){
          return aA+bA;
        }

        if(by1 > ay2 || by2 < ay1){
          return aA+bA;
        }
        
        


        int x1 = Math.max(ax1,bx1);
        int x2 = Math.min(ax2,bx2);

        int y1 = Math.max(ay1,by1);
        int y2 = Math.min(ay2,by2);
        
        int xA = (Math.abs(x1 - x2) * Math.abs(y1 - y2));

        return (aA+bA) - xA;

    }
}