class Solution {
    int i = 0;
    public String decodeString(String s) {
        return solve(s);
    }
    private String solve(String s) {
        StringBuilder ans = new StringBuilder();
        int nums = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            if(Character.isDigit(c)) {
                nums = nums * 10 + (c - '0');
            } else if (c == '[') {
                String z = solve(s);
                for(int j = 0; j < nums; j++) {
                    ans.append(z);
                }
                nums = 0;
            } else if(c == ']') {
                return ans.toString();
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}