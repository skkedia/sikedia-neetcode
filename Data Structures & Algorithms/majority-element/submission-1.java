class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        int ele = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == ele) {
                cnt++;
            } else {
                cnt--;
                if(cnt == 0) {
                    ele = nums[i];
                    cnt = 1;
                }
            }
        }
        return ele;
    }
}