class Solution {
    private int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == arr[0] && back(i, j, 0, n, m, arr.length, board, arr, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean back(
        int i, int j, int c, int n, int m, int len, char[][] board, char[] arr, String word) {
        if (c == len) {
            return true;
        }
        if (!isValid(i, j, n, m)) {
            return false;
        }
        if (board[i][j] != arr[c]) {
            return false;
        }
        char z = board[i][j];
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (back(x, y, c + 1, n, m, len, board, arr, word)) {
                return true;
            }
        }
        board[i][j] = z;
        return false;
    }

    private boolean isValid(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        return true;
    }
}
