// import java.util.HashMap;

// class Solution {
//     public int pivotIndex(int[] nums) {

//         int n = nums.length;

//         HashMap<Integer, Integer> prefixMap = new HashMap<>();

//         int prefixSum = 0;

//         // Store prefix sums
//         for (int i = 0; i < n; i++) {
//             prefixSum += nums[i];
//             prefixMap.put(i, prefixSum);
//         }

//         int totalSum = prefixSum;

//         for (int i = 0; i < n; i++) {

//             int leftSum = (i == 0) ? 0 : prefixMap.get(i - 1);

//             int rightSum = totalSum - leftSum - nums[i];

//             if (leftSum == rightSum) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }                                     
                                                                                                           


class Solution {
    public int pivotIndex(int[] nums) {
        //calculate total sum
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum=totalSum+nums[i];
        }
        //Check for equality
        int leftSum=0;
        for(int j=0;j<nums.length;j++){
            //Calculate rightSum dyamically by this formula
            int rightSum=totalSum-leftSum-nums[j];
            if(rightSum==leftSum){
                return j;
            }
            leftSum+=nums[j];
        }
        return -1;
    }
}