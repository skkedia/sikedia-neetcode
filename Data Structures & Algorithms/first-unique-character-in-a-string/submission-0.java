class Solution {
    public int firstUniqChar(String s) {
        int[] fre = new int[26];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            fre[c - 'a']++;
            if(idx[c - 'a'] == -1) {
                idx[c - 'a'] = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < fre.length; i++) {
            if(fre[i] == 1) {
                min = Math.min(min, idx[i]);
            }
        }
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}