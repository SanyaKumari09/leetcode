class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        // Find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no breakpoint, reverse entire array
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find next greater element
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // Reverse suffix
        reverse(nums, idx + 1, n - 1);
    }

    private void reverse(int[] nums, int a, int b) {
        while (a < b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}