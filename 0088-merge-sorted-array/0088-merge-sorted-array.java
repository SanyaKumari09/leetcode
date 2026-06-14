class Solution {        
    public void merge(int[] nums1, int m, int[] nums2, int n) {

      int i=m-1;
      int j=n-1;
      int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
               nums1[k]=nums1[i];
               i--;
               k--;
            }
            else{
               nums1[k]=nums2[j];
               j--;
               k--;
             }
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
}




// class Solution {        
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i=0;
//         int j=0;
//         ArrayList<Integer>list = new ArrayList<>();
//         while(i<m && j<n){
//            if(nums1[i] <= nums2[j]){
//             list.add(nums1[i]);
//             i++;
//            }else{        
//             list.add(nums2[j]);
//             j++;
//            }
//         }
//         while(i<m){
//             list.add(nums1[i]);
//             i++;
//         }
//         while(j<n){
//             list.add(nums2[j]);
//             j++;
//         }

//         //Copy back to num1
//         for(int k=0;k<list.size();k++){
//             nums1[k]=list.get(k);
//         }

//     }

// }