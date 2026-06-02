class Solution {
    public int maxSubArray(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxNum=Math.max(sum, maxNum);
            if(sum<0){
                sum=0;
            }
        }
        return maxNum;
    }
}