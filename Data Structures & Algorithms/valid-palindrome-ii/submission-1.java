class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        boolean flag = false;

        while(left <= right) {
            char x = s.charAt(left);
            char y = s.charAt(right);

            if(x != y) {
                return isPal(s, left + 1, right) || isPal(s, left, right - 1);
                // if(!flag) {
                //     if(left + 1 <= right && s.charAt(left + 1) == y) {
                //         left++;
                //     } else if (right - 1 >= left && s.charAt(right - 1) == x) {
                //         right--;
                //     } else {
                //         return false;
                //     }
                //     flag = true;
                // } else {
                //     return false;
                // }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isPal(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}