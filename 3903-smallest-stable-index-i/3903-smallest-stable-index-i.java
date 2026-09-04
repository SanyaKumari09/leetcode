class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Precompute the suffix minimums from right to left
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        
        // Step 2: Traverse from left to right, track prefix maximums, and evaluate
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            
            // If instability score is <= k, return the current index instantly
            if (leftMax - rightMin[i] <= k) {
                return i;
            }
        }
        
        // If no stable index is found
        return -1;
    }
}
