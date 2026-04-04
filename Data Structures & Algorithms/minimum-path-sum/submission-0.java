class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0,0,n,m,grid,dp);
    }
    private int dfs(int x, int y, int n, int m, int[][] grid, int[][] dp) {
        if(x == n - 1 && y == m - 1) {
            return grid[x][y];
        }

        if(x == n || y == m) {
            return Integer.MAX_VALUE;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int down = dfs(x + 1, y, n, m, grid, dp);
        int up = dfs(x, y + 1, n, m, grid, dp);
        dp[x][y] = grid[x][y] + Math.min(down, up);
        return dp[x][y];
    }
}
