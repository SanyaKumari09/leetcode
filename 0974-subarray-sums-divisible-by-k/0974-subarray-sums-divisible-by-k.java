class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefSum=0;
        int count=0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n ;i++){
          prefSum+=nums[i];
          int rem= ((prefSum % k) + k) % k;
          if(map.containsKey(rem)){
            count+=map.get(rem);
          }
          map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}