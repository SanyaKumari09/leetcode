class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }

            if (map.containsKey(prefixSum)) {

                int len = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, len);

            } else {

                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}



// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n=nums.length;
//         int len=0;
//         int maxLen = 0;
//         for(int i=0;i<n;i++){
//             int cnt0 = 0;
//             int cnt1 = 0;
//             for(int j=i;j<n;j++){
//                 if(nums[j]==0){
//                     cnt0++;
//                 }else{
//                     cnt1++;
//                 }
//                 if(cnt0 == cnt1){
//                    maxLen = Math.max(maxLen, j - i + 1);
//                 }
//             }
            
//         }
//         return maxLen;
//     }
// }