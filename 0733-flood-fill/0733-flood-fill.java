class Solution {
    public void doFill(int[][] image, int ocolor,int sr, int sc, int color){
        
        image[sr][sc] = color;
        
        if(sr-1>=0 && image[sr-1][sc] == ocolor)
            doFill(image, ocolor,sr-1,sc,color);
        
        if(sc-1>=0 && image[sr][sc-1] == ocolor)
            doFill(image, ocolor,sr,sc-1,color);
        
        if(sr+1 < image.length && image[sr+1][sc] == ocolor)
            doFill(image, ocolor,sr+1,sc,color);
        
        if(sc+1 < image[0].length && image[sr][sc+1] == ocolor)
            doFill(image, ocolor,sr,sc+1,color);
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rs = image.length;
        int cs = image[0].length;
        
         if(rs == 0)
            return image;
        
        if(cs == 0)
            return image;
        
        int ocolor = image[sr][sc];
        
        if(image[sr][sc] != color)
            doFill(image, ocolor,sr,sc,color);
        
        return image;
    }
}