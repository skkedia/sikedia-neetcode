class Solution {
    private boolean flag = false;
    private int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        List<int[]> l = new ArrayList<>();
        char[] arr = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(flag) {
                    return true;
                }
                if (board[i][j] == arr[0]) {
                    back(i, j, 0, n, m, arr.length, board, arr, word, new StringBuilder());
                }
            }
        }
        return flag;
    }

    private void back(int i, int j, int c, int n, int m, int len, char[][] board, char[] arr,
        String word, StringBuilder sb) {
        if (c >= len) {
            return;
        }

        if (board[i][j] == arr[c]) {
            sb.append(arr[c]);
            char z = board[i][j];
            board[i][j] = '#';
            if (sb.toString().equals(word)) {
                flag = true;
                return;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (isValid(x, y, n, m)) {
                    back(x, y, c + 1, n, m, len, board, arr, word, sb);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            board[i][j] = z;
        }
    }

    private boolean isValid(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        return true;
    }
}
