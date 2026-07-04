class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int rows = 0;
        int cols = matrix[0].length-1;

        while (rows < n && cols >= 0) {

            if (matrix[rows][cols] == target) {
                return true;
            }
            else if (matrix[rows][cols] < target) {
                rows++;
            }
            else {
                cols--;
            }
        }

        return false;
    }
}