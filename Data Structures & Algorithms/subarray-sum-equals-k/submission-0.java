class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            count += hm.getOrDefault(diff, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}