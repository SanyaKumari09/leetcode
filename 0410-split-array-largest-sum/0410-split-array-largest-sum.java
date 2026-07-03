class Solution {
    public int splitArray(int[] nums, int k) {
        int low = findMax(nums);       // minimum capacity = heaviest package
        int high = findSum(nums);      // maximum capacity = sum of all packages

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
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
   
    boolean isPossible(int nums[], int k, int mid){
        int sum=0;
        int cnt=1;

        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
               sum+=nums[i];
            }else{
                cnt++;
                sum=nums[i];
            }
        }
        if(cnt>k){
            return false;
        }else{
            return true;
        }
    }
}