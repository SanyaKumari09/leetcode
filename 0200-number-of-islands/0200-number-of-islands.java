class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, grid, vis, n , m);
                    count++;
                }    
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid, boolean vis[][], int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == true || grid[i][j] == '0'){
            return;
        }

        vis[i][j] = true;
        //top 
        dfs(i-1, j, grid, vis, n, m);
        //bottom
        dfs(i+1, j, grid, vis, n, m);
        //left
        dfs(i, j-1, grid, vis, n, m);
        //right
        dfs(i, j+1, grid, vis, n, m);
    }
}