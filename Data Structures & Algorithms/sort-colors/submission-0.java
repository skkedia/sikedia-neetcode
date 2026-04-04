class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero +=1;
            } else if(nums[i] == 1) {
                one += 1;
            } else {
                two += 1;
            }
        }

        int count = 0;
        for(int i = 0; i < zero; i++) {
            nums[count++] = 0;
        }
        for(int i = 0; i < one; i++) {
            nums[count++] = 1;
        }
        for(int i = 0; i < two; i++) {
            nums[count++] = 2;
        }
    }
}