class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = Math.min(n, k);
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < right; i++) {
            if(hm.get(nums[i]) != null) {
                return true;
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        while(right < n) {
            int l = nums[left];
            int r = nums[right];
            if(hm.get(r) != null) {
                return true;
            }
            hm.put(l, hm.getOrDefault(l , 0) - 1);
            hm.put(r, hm.getOrDefault(r , 0) + 1);
            if(hm.get(l) == 0) {
                hm.remove(l);
            }
            left++;
            right++;
        }
        return false;
    }
}