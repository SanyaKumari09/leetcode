class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            if(set.contains(num)){
                ansSet.add(num);
            }
        }

        int idx=0;
        int[] res = new int[ansSet.size()];

        for(int n : ansSet){
            res[idx++] = n;
        }

        return res;


    }
}