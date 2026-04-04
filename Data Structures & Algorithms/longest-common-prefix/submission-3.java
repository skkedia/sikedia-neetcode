class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        char[] arr = strs[0].toCharArray();
        char[] brr = strs[strs.length - 1].toCharArray();
        for(int i = 0; i < Math.min(arr.length, brr.length); i++) {
            if(arr[i] != brr[i]) {
                break;
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}