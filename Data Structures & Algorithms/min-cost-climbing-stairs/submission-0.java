class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, 0, n, cost, dp), solve(1, 0, n, cost, dp));
    }

    private int solve(int idx, int cur, int n,int[] cost, int[] dp) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int onestep = solve(idx + 1, cur, n, cost, dp);
        int twostep = solve(idx + 2, cur, n, cost, dp);

        dp[idx] = cost[idx] + Math.min(onestep, twostep);

        return dp[idx];
    }
}
