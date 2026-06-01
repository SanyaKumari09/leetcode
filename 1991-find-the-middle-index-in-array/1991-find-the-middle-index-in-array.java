class Solution {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;

        //calculate total sum
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }

        int ls=0, rs=0;
        for(int i=0;i<n;i++){
            rs = totalSum - ls - nums[i];
            if(ls == rs){
                return i;
            }
            ls+=nums[i];
        }

        return -1;
    }
}