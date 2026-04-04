class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, -1);
        return Math.max(solve(0, n - 1, nums, dp), solve(1, n, nums, dp1));
    }

    private int solve(int idx, int n, int[] nums, int[] dp) {
        if(idx >= n) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int take = solve(idx + 2, n, nums, dp);
        int not = solve(idx + 1, n, nums, dp);
        
        dp[idx] = Math.max(nums[idx] + take, not);
        return dp[idx];
    }
}
