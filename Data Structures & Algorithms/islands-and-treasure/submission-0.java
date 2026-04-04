class Solution {
    public void islandsAndTreasure(int[][] grid) {
		if(grid == null) {
			return;
		}
		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> qu = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0) {
					qu.add(new int[] {i, j});
				}
			}
		}

		if(qu.isEmpty()) return;
		int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int row = cur[0];
			int col = cur[1];
			for(int[] dir : dirs) {
				int i = row + dir[0];
				int j = col + dir[1];
				if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] != Integer.MAX_VALUE) {
					continue;
				}
				qu.add(new int[] {i, j});
				grid[i][j] = grid[row][col] + 1;
			}
		}
	}
}
