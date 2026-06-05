class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int need = target-nums[i];
            if(map.containsKey(need)){
                return new int [] {i, map.get(need)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}        



// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//           for(int j=i+1;j<n;j++){
//             if(nums[i]+nums[j]==target){
//                return new int[]{i,j};
//             }
//           }
//         }
//         //No solution found 
//         return new int[]{};
//     }
// }

