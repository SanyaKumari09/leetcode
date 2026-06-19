class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int[] cand = {
                nums[i],
                nums[i] * maxProd,
                nums[i] * minProd
            };

            int newMax = Math.max(cand[0],
                           Math.max(cand[1], cand[2]));

            int newMin = Math.min(cand[0],
                           Math.min(cand[1], cand[2]));

            maxProd = newMax;
            minProd = newMin;

            result = Math.max(result, maxProd);
        }

        return result;
    }
}