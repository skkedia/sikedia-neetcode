class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, 0, dp);
        //return dp[n];
    }
    private int solve(int n, int cur, int[] dp) {
        if(cur == n) {
            return 1;
        }
        if(cur > n) {
            return 0;
        }
        if(dp[cur] != -1) {
            return dp[cur];
        }
        return dp[cur] = solve(n, cur + 1, dp) + solve(n, cur + 2, dp);
    }
}
