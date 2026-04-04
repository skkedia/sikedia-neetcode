class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        for(int i = 0; i < op.length; i++) {
            if(op[i].equals("+")) {
                int x = stk.pop();
                int y = stk.pop();
                int z = x + y;
                stk.push(y);
                stk.push(x);
                stk.push(z);
            } else if(op[i].equals("D")) {
                stk.push(stk.peek() * 2);
            } else if(op[i].equals("C")) {
                stk.pop();
            } else {
                stk.push(Integer.parseInt(op[i]));
            }
        }
        while(!stk.isEmpty()) {
            ans += stk.pop();
        }
        return ans;
    }
}