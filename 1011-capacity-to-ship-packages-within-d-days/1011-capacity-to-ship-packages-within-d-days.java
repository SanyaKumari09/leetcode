class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = findMax(weights);       // minimum capacity = heaviest package
        int high = findSum(weights);      // maximum capacity = sum of all packages

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (noOfDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int findSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private int noOfDays(int[] wt, int cap) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < wt.length; i++) {
            if (load + wt[i] > cap) {
                days++;
                load = 0;
            }
            load += wt[i];
        }
        return days;
    }
}
