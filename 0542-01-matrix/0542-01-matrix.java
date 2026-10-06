class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }else{
                    dist[i][j] = -1;
                }
            } 
        }
 
        int[][] direc = {
            {0,-1}, 
            {0,1}, 
            {-1,0}, 
            {1,0}
        };

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : direc){
                int nr = r + d[0];
                int nc = c + d[1];

                //Check if nr , nc exists in the matrix or not
                if(nr >= 0 && nr < m && 
                nc >= 0 && nc < n && 
                dist[nr][nc] == -1){

                    dist[nr][nc] = dist[r][c] + 1;

                    q.offer(new int[]{nr,nc}); 
                }
            }
        }
        return dist;
    }
}