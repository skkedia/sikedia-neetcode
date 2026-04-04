class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];

        Stack<int[]> stk = new Stack<>();

        for(int i = 0; i < t.length; i++) {
            int cur = t[i];
            while(!stk.isEmpty() && cur > stk.peek()[1]) {
                int prev = stk.pop()[0];
                ans[prev] = i - prev;
            }
            stk.push(new int[]{i, cur});
        }
        return ans;
    }
}
