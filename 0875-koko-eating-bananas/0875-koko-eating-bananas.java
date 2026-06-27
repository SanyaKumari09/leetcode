class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);
        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long totalH = totalHour(piles, mid);

            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int bananas : piles) {
            max = Math.max(max, bananas);
        }

        return max;
    }

    private long totalHour(int[] piles, int speed) {

        long totalH = 0;

        for (int bananas : piles) {
            totalH += (bananas + speed - 1L) / speed;
        }

        return totalH;
    }
}