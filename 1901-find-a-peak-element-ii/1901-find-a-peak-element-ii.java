class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            int col=maxCol(mat , m , mid);

            boolean up=(mid>0 && mat[mid-1][col]>mat[mid][col]);
            boolean down=(mid<n-1 && mat[mid+1][col]>mat[mid][col]);

            if(!up && !down){
                return new int[]{mid, col};
            }else if(up){
                high=mid-1;
            }else{
                low=mid+1;
            } 
        } 
        return new int[]{-1,-1};
    }
    private int maxCol(int mat[][],int m , int mid){
        int maxCol=0;
        for(int c=1;c<m;c++){
            if(mat[mid][c]>mat[mid][maxCol]){
                maxCol=c;
            }
        }
        return maxCol;
    }
}