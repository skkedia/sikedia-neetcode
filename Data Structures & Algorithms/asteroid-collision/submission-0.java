class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            boolean destroyed = false;
            while(!stk.isEmpty() && cur < 0 && stk.peek() > 0) {
                int top = stk.peek();
                if(Math.abs(cur) > Math.abs(top)) {
                    stk.pop();
                } else if(Math.abs(cur) == Math.abs(top)) {
                    destroyed = true;
                    stk.pop();
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed) {
                stk.push(cur);
            }
        }
        int[] ans = new int[stk.size()];
        int i = ans.length - 1;
        while(!stk.isEmpty()) {
            ans[i--] = stk.pop();
        }
        return ans;
    }
}