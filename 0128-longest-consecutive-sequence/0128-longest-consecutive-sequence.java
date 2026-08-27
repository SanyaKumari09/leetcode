class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int maxLen = 0;
        int count = 0;
        int curr;

        for(int num : set){

            if(!set.contains(num-1)){
                curr = num;
                count = 1;

                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}