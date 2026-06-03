class Solution{
    public int subarraySum(int nums[],int k){
        int n=nums.length;
        int currSum=0;
        int count=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
                count = count+ map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}   















// class Solution{
//     public int subarraySum(int nums[],int k){
//         int n=nums.length;
//         int prefixSum=0;
//         int count=0;
//         HashMap<Integer,Integer>map=new HashMap<>();
//         map.put(0, 1);
//         for(int i=0;i<n;i++){
//             prefixSum+=nums[i];
//             int remove=prefixSum-k;
//             if(map.containsKey(remove)){
//                 count+=map.get(remove);
//             }
//             map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
//         }
//         return count;
//     }
// }

// // class Solution {
// //     public int subarraySum(int[] nums, int k) { 
// //         int n=nums.length;
// //         int maxLen=0;
// //         int count=0;
// //         for(int i=0;i<n;i++){
// //            int sum=0;
// //            for(int j=i;j<n;j++){
// //               sum+=nums[j];
// //               if(sum==k){
// //                 count++;
// //                 maxLen=Math.max(maxLen,j-i+1);
// //               }
// //            }
// //         }
// //         return count;
// //     }
// // }