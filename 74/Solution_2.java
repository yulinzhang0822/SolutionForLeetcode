class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) {
            return false;
        }
        for(int i=0; i<matrix.length; i++) {
            int first = matrix[i][0], last = matrix[i][matrix[i].length-1];
            if(target<first) {
                return false;
            } 
            if(target>last) {
                if(i<matrix.length) {
                    continue;
                } else {
                    return false;
                }
            }
            for(int j=0; j<matrix[i].length; j++) {
                if(target==matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
