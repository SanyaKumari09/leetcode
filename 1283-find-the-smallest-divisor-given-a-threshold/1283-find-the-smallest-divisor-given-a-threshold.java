class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = findMax(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum =0;

            for(int j=0; j<nums.length; j++){
                sum+=(nums[j]+mid-1)/mid;
            }
            if(sum<=threshold){
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
}
