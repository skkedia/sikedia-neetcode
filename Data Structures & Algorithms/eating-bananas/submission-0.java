class Solution {
    public int minEatingSpeed(int[] p, int h) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < p.length; i++) {
            max = Math.max(max, p[i]);
        }
        int low = 1;
        int high = max;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(canEat(p, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean canEat(int[] p, int b, int h) {

        int c = 0;
        for(int i = 0; i < p.length; i++) {
            if(b > p[i]) {
                c += 1;
            } else {
                c += (p[i] % b == 0 ? p[i] / b : (p[i] / b) + 1);
            }
            
            if(c > h) {
                return false;
            }
        }
        return true;
    }
}
