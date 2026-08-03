class Solution {
    public int subarraySum(int[] nums) {
        int n=nums.length;
        int prefSum[] = new int[n+1];
        int ans=0;
        for(int i=0;i<n;i++){
            prefSum[i+1]=prefSum[i]+nums[i];
        }

        for(int i=0;i<n;i++){
            int start = Math.max(0, i-nums[i]);
            ans+=prefSum[i+1]- prefSum[start];
        }

        return ans;
    }
}