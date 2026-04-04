class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.max(solve(0, 0, n, nums, dp), solve(1, 0, n, nums, dp));
    }

    private int solve(int idx, int cur, int n, int[] nums, int[] dp) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        int take = solve(idx + 2, nums[idx], n, nums, dp);
        int not = solve(idx + 1, nums[idx], n, nums, dp);

        dp[idx] =  Math.max(nums[idx] + take, not);
        return dp[idx];
    }
}
