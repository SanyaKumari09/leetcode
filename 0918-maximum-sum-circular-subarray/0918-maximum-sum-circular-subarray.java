class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int curMax=0, maxSum=nums[0];
        int curMin=0, minSum=nums[0];

        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
        }

        if(maxSum < 0) {
            return maxSum;
        }
         return  Math.max(maxSum, totalSum - minSum);
    }
}