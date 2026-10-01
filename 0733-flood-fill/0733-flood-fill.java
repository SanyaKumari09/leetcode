class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        int newColor = color;
        int i= sr;
        int j=sc;
        dfs(image, i,j, orgColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int orgColor, int newColor){
        int n = image.length;
        int m = image[0].length;
        if(i < 0|| j < 0 || i >= n || j >= m || image[i][j] != orgColor || image[i][j] == newColor){
            return;
        }

        image[i][j] = newColor;

        //top
        dfs(image, i-1, j, orgColor, newColor);
        //bottom
        dfs(image, i+1, j, orgColor, newColor);
        //left
        dfs(image, i, j-1, orgColor, newColor);
        //right
        dfs(image, i, j+1, orgColor, newColor);


    }
}