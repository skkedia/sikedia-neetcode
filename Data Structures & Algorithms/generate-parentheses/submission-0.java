class Solution {
    StringBuilder sb;
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        ans = new ArrayList<>();
        back(0, 0, n);
        return ans;
    }

    private void back(int o, int c, int n) {
        if(sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }

        if(n > o) {
            sb.append("(");
            back(o + 1, c, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(o > c) {
            sb.append(")");
            back(o, c + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
