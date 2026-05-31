//Optimal approach 

class Solution {
    public int[] leftRightDifference(int[] nums) {
       int n=nums.length;

       //caluclating total sum
      int totalSum=0;
       for(int i=0;i<n;i++){
        totalSum+=nums[i];
       } 

       int[] leftArr= new int[n];
       int[] rightArr= new int[n];

       int ls=0, rs=0;

       for(int j=0;j<n;j++){
        rs=totalSum-ls-nums[j];
          leftArr[j]=ls;
          rightArr[j]=rs;
          ls+=nums[j];
       }
        //Calculating differences
        int res[]=new int[n];
        for(int k=0;k<n;k++){
           int ans=Math.abs(rightArr[k]-leftArr[k]);
           res[k]=ans;
        }
        return res;
    }
}


// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n=nums.length;
//         int[] leftArr= new int[n];
//         int[] rightArr= new int[n];
//         for(int i=0;i<n;i++){
//             int ls=0, rs=0;
//             //Calculate left sum for each i
//             for(int j=0;j<i;j++){
//                ls+=nums[j];
//             }
//             leftArr[i]=ls;
//              //Calculate right sum for each i
//             for(int j=i+1;j<n;j++){
//                rs+=nums[j];
//             }
//             rightArr[i]=rs;
//         }
//         //Calculating differences
//         int res[]=new int[n];
//         for(int k=0;k<n;k++){
//            int ans=Math.abs(rightArr[k]-leftArr[k]);
//            res[k]=ans;
//         }
//       return res;
//     }
// }