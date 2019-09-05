//Brute Force
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]==target) {
                    return true;
                }
            }
        }
        return false;
    }
}
//Time:O(N^2),Space:O(1)
