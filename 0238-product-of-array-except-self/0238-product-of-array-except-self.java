class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[] = new int [n];
        int leftPr=1;
        int rightPr=1;

        for(int i=0;i<n;i++){
            res[i]=leftPr;
            leftPr=leftPr*nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*rightPr;
            rightPr=rightPr*nums[i];
        }

        return res;
    }
}