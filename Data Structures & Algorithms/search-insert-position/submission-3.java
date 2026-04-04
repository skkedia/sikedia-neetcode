class Solution {
    public int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        int idx = 0;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            // if(mid - 1 >= 0 && mid + 1 <= high && arr[mid - 1] < target && arr[mid + 1] > target) {
            //     return mid;
            // }
            if(arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}