class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int max = matrix[i].length - 1;
            if(target >= matrix[i][0] && target <= matrix[i][max]) {
                int low = 0;
                int high = matrix[i].length - 1;
                while(low <= high) {
                    int mid = low + (high - low) / 2;
                    if(matrix[i][mid] == target) {
                        return true;
                    }
                    if(matrix[i][mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
