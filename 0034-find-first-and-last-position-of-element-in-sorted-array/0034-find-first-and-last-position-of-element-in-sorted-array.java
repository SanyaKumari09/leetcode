class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstEl(nums,target);
        int last = lastEl(nums,target);

        return new int[]{first,last};
    }

    private int firstEl(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                high=mid-1; //search in left
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    private int lastEl(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1; //serach in right 
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}